package cn.sp.io.nio;

/**
 * @Author: 2YSP
 * @Description:
 * @Date: Created in 2018/1/16
 */
public class TimeClient {
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

        new Thread(new TimeClientHandle("127.0.0.1",port),"Time-Client-001").start();
    }
}
