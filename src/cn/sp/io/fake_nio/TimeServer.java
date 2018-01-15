package cn.sp.io.fake_nio;


import cn.sp.io.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: 2YSP
 * @Description: 利用线程池和队列建立伪异步I/O 服务端
 * @Date: Created in 2018/1/15
 */
public class TimeServer {

    public static void main(String[] args)throws IOException {
        int port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                //采用默认值
                e.printStackTrace();
            }
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("the time server is start in port:"+port);
            Socket socket = null;
            TimeServerHandleExecutePool executePool = new TimeServerHandleExecutePool(50,10000);
            while (true){
                socket = server.accept();
                executePool.execute(new TimeServerHandler(socket));
            }
        }finally {
            if (server != null){
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}
