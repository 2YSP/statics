package cn.sp.t7.threadLocal;

/**
 * Created by 2YSP on 2017/11/23.
 * ThreadLocal:用于保存每个线程的变量，具有隔离性
 */
public class M {
    public static void main(String[] args)throws Exception {
        ThreadA threadA = new ThreadA();
        threadA.start();
        Thread.sleep(2000);
        ThreadB threadB = new ThreadB();
        threadB.start();
    }
}
