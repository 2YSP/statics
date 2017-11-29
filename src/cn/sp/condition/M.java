package cn.sp.condition;

/**
 * Created by 2YSP on 2017/11/29.
 */
public class M {
    public static void main(String[] args)throws Exception {
        MyService service = new MyService();
        ThreadA ta = new ThreadA(service);
        ta.start();
        Thread.sleep(2000);
        service.signal();
    }
}
