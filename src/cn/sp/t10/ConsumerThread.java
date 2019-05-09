package cn.sp.t10;

/**
 * Created by 2YSP on 2019/3/19.
 */
public class ConsumerThread implements Runnable{

    private ValueObject valueObject;

    public ConsumerThread(ValueObject valueObject){
        this.valueObject = valueObject;
    }


    @Override
    public void run(){
        while (true){
            synchronized (ValueObject.class){
                if (valueObject.value == 0){
                    try {
                        System.out.println("没有任务进入等待。。。");
                        ValueObject.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                --valueObject.value;
                System.out.println("Consumer value="+valueObject.value);
                ValueObject.class.notify();
            }
        }
    }
}
