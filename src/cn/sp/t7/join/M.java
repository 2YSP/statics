package cn.sp.t7.join;

/**
 * Created by 2YSP on 2017/11/23.
 */
public class M {

    public static void main(String[] args)throws Exception {
        MyThread thread = new MyThread();
        thread.start();
        thread.join();
        System.out.println("我想当thread对象执行完毕后再执行");
    }
}
