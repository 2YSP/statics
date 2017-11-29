package cn.sp.condition;

/**
 * Created by 2YSP on 2017/11/29.
 */
public class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService myService){
        this.service = myService;
    }
    @Override
    public void run() {
        service.await();
    }
}
