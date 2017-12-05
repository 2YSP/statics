package cn.sp.t8.singleton_1;

/**
 * Created by 2YSP on 2017/12/5.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}
