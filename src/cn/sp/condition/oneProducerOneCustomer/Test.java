package cn.sp.condition.oneProducerOneCustomer;

/**
 * Created by 2YSP on 2017/11/29.
 * 一生产者一消费者
 */
public class Test {

    public static void main(String[] args) {
        Service service = new Service();
        MyThreadA a = new MyThreadA(service);
        a.start();
        MyThreadB b = new MyThreadB(service);
        b.start();
    }
}
