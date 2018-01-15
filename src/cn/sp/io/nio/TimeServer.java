package cn.sp.io.nio;

import cn.sp.io.bio.TimeServerHandler;
import cn.sp.io.fake_nio.TimeServerHandleExecutePool;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: 2YSP
 * @Description: 使用NIO创建服务端
 * @Date: Created in 2018/1/15
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                //采用默认值
                e.printStackTrace();
            }
        }

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
