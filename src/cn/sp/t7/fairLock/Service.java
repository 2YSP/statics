package cn.sp.t7.fairLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 2YSP on 2017/12/5.
 */
public class Service {
    private ReentrantLock lock;

    public Service(boolean isFair){
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获得锁定");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
