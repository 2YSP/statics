package cn.sp.t3;

/**
 * Created by 2YSP on 2017/11/13.
 */
public class Test {

    public static void main(String[] args) {
        MyList service = new MyList();
        ThreadA t1 = new ThreadA(service);
        t1.setName("A");
        t1.start();
        ThreadB t2 = new ThreadB(service);
        t2.setName("B");
        t2.start();
    }
}
