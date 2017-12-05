package cn.sp.t8.singleton_1;

/**
 * Created by 2YSP on 2017/12/5.
 */
public class M {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
        //输出结果不一致
    }
}
