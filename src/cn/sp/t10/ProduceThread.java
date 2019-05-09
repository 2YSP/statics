package cn.sp.t10;


/**
 * Created by 2YSP on 2019/3/19.
 */
public class ProduceThread implements Runnable{

    private ValueObject valueObject;

    public ProduceThread(ValueObject valueObject){
        this.valueObject = valueObject;
    }

    @Override
    public void run() {
        while (true){
            synchronized (ValueObject.class){
                if (valueObject.value == 1){
                    try {
                        System.out.println("不需要生产。。。。");
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
                ++valueObject.value;
                System.out.println("Product value="+valueObject.value);
                ValueObject.class.notify();
            }
        }
    }
}
