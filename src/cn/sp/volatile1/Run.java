package cn.sp.volatile1;

/**
 * Created by 2YSP on 2017/11/13.
 * volatile:强制线程读取公共堆栈中的变量值，而不是从线程私有堆栈中读取，从而保证是最新的值
 */
public class Run {
    public static void main(String[] args) throws Exception{
        RunThread thread = new RunThread();
        thread.start();
        thread.sleep(4000);
        thread.setRunning(false);
        System.out.println("已经赋值为false");
    }
}
