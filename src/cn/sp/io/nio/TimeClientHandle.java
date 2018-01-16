package cn.sp.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: 2YSP
 * @Description:
 * @Date: Created in 2018/1/16
 */
public class TimeClientHandle implements Runnable {
    private String host;
    private int port;
    private SocketChannel socketChannel;
    private Selector selector;

    private volatile boolean stop = false;

    public TimeClientHandle(String host,int port){
        this.host = host;
        this.port = port;
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!stop){
            try {
                //每隔1秒检查是否有准备好的读/写缓冲区
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    //遍历完就去除
                    it.remove();
                    try {
                        handleInput(key);
                    }catch (Exception e){
                        if (key != null){
                            key.cancel();
                            if (key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        //多路复用器关闭后，所以注册在上面的channel和pipe等资源都会被自动去注册并关闭
        //所以不需要重复去释放资源
        if (selector != null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doConnect()throws IOException {
        //如果连接成功，则注册到多路复用器上，发送请求消息，读应答
        if (socketChannel.connect(new InetSocketAddress(host,port))){
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel);
        }else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel socketChannel)throws IOException {
        byte[] req = "QUERY TIME ORDER".getBytes();
        ByteBuffer writerBuffer = ByteBuffer.allocate(req.length);
        writerBuffer.put(req);
        writerBuffer.flip();
        socketChannel.write(writerBuffer);
        if (!writerBuffer.hasRemaining()){
            //没有缓存剩余
            System.out.println("Send order 2 server succeed");
        }
    }

    private void handleInput(SelectionKey key)throws IOException{
        if (key.isValid()){
            //判读是否连接成功
            SocketChannel sc = (SocketChannel) key.channel();
            if (key.isConnectable()){
                if (sc.finishConnect()){
                    sc.register(selector,SelectionKey.OP_READ);
                    doWrite(sc);
                }else {
                    //连接失败，进程退出
                    System.exit(1);
                }
            }
            if (key.isReadable()){
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes,"UTF-8");
                    System.out.println("Now is: "+body);
                    this.stop = true;
                }else if (readBytes < 0){
                    key.channel();
                    sc.close();
                }else {
                    ;//读到0字节，忽略
                }

            }
        }
    }
}
