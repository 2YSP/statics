package cn.sp.t10;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by 2YSP on 2019/3/19.
 */
public class MM {

    public static void main(String[] args) {
//        ValueObject valueObject = new ValueObject();
//        Thread t1 = new Thread(new ProduceThread(valueObject));
//        Thread t2 = new Thread(new ConsumerThread(valueObject));
//        t1.start();
//        t2.start();

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> future = pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date().toString() + ": 我又定时执行了");
            }
        }, 1000, 5000, TimeUnit.MILLISECONDS);

        System.out.println("===============");
    }
}
