package cn.sp.condition.oneProducerOneCustomer;

/**
 * Created by 2YSP on 2017/11/29.
 */
public class MyThreadA extends Thread {
    private Service service;

    public MyThreadA(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        while (true){

        service.set();
        }
    }
}
