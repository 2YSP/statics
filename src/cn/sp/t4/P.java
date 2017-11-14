package cn.sp.t4;

/**
 * Created by 2YSP on 2017/11/14.
 */
public class P {
    private String lock;

    public P(String lock){
        this.lock = lock;
    }

    public void setValue(){
        synchronized (lock){
            try{
                if (!"".equals(ValueObject.value)){
                    lock.wait();
                }
                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                System.out.println("set的值是"+value);
                ValueObject.value = value;
                lock.notify();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
