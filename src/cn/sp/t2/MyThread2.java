package cn.sp.t2;

/**
 * Created by 2YSP on 2017/11/9.
 * yield()方法会使该线程让出CPU资源
 */
public class MyThread2 extends Thread {

    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        int count = 0;
        for (int i = 0 ; i< 90000000;i++){
//            Thread.yield();
            count = count + (i+1);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时："+(end-begin)+"毫秒");
    }

    public static void main(String[] args) throws Exception{
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

    }
}
