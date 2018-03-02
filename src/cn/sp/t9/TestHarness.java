package cn.sp.t9;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: 2YSP
 * @Description: 在计时测试中使用CountDownLatch来启动和停止线程
 * @Date: Created in 2018/3/2
 */
public class TestHarness {

    public long timeTasks(int nThreads,final Runnable task)throws InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0;i < nThreads;i++){

            Thread t = new Thread(){
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        }finally {
                            endGate.countDown();
                        }
                    }catch (InterruptedException e){

                    }

                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
