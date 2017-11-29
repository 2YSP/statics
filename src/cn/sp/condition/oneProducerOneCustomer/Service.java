package cn.sp.condition.oneProducerOneCustomer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 2YSP on 2017/11/29.
 */
public class Service {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean flag = false;

    public void set(){
        try {
            lock.lock();
            while (flag == true){
                condition.await();
            }
            System.out.println("打印☆");
            Thread.sleep(1000);
            flag = true;
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void get(){
        try {
            lock.lock();
            while (flag == false){
                condition.await();
            }
            System.out.println("打印★");
            Thread.sleep(1000);
            flag = false;
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
