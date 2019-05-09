package cn.sp.t10;

import java.util.concurrent.*;

/**
 * Created by 2YSP on 2019/3/18.
 */
public class ShutdownThreadPool {

    private static void  executorService()throws InterruptedException{
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>(10);
        ExecutorService service = new ThreadPoolExecutor(5,5,1, TimeUnit.SECONDS,queue);
        service.execute(()->{
            System.out.println("running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.execute(()->{
            System.out.println("running2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.shutdown();
        while (!service.awaitTermination(1,TimeUnit.SECONDS)){
            System.out.println("线程还在执行");
        }
        System.out.println  ("Main Over!");
    }

    public static void main(String[] args)throws Exception {
        executorService();
    }
}
