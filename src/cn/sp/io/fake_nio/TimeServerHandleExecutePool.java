package cn.sp.io.fake_nio;

import java.util.concurrent.*;

/**
 * @Author: 2YSP
 * @Description:
 * @Date: Created in 2018/1/15
 */
public class TimeServerHandleExecutePool  {

    private ExecutorService executor;

    TimeServerHandleExecutePool(int maxPoolSize,int queueSize){
        executor = new ThreadPoolExecutor(Runtime.getRuntime().
                availableProcessors(),maxPoolSize,120L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable task){
        executor.execute(task);
    }
}
