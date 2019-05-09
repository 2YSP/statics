package cn.sp.condition;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 2YSP on 2019/4/20.
 */
public class ThreadT implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return new Integer(10);
    }

    public static void main(String[] args) throws Exception {

        ThreadT threadT = new ThreadT();
        FutureTask<Integer> task = new FutureTask<Integer>(threadT);
        long start = System.currentTimeMillis();
        new Thread(task).start();
        // 会阻塞主线程
        Integer result = task.get();
        System.out.println("结果是：" + result);

        System.out.println("用时：" + (System.currentTimeMillis() - start) + "ms");
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("ThreadT-%d")
                .build();
//        ThreadFactory threadFactory = new CustomThreadFactory();
        ExecutorService pool = Executors.newFixedThreadPool(3, threadFactory);
//        pool.submit();
        for (int i = 0; i < 10; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程是:" + Thread.currentThread().getName());
                }
            });
        }
        pool.shutdown();
    }

    private final static class CustomThreadFactory implements ThreadFactory {

        private AtomicInteger count = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            String name = ThreadT.class.getSimpleName() + "-" + count.incrementAndGet();
            return new Thread(r, name);
        }
    }
}
