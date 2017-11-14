package cn.sp.t4;

/**
 * Created by 2YSP on 2017/11/14.
 */
public class C {
    private String lock;

    public C(String lock){
        this.lock = lock;
    }

    public void getValue(){
        synchronized(lock){
            try {
                if ("".equals(ValueObject.value)){
                        lock.wait();
                }
                System.out.println("get的值是"+ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
