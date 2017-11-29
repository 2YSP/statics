package cn.sp.condition.oneProducerOneCustomer;

/**
 * Created by 2YSP on 2017/11/29.
 */
public class MyThreadB extends Thread {
    private Service service;

    public MyThreadB(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        while (true){
            service.get();

        }
    }
}
