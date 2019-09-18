package cn.sp.t12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 2YSP on 2019/9/18.
 */
public class ThreadPoolDemo {

  /**
   * 串行执行所有任务。如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。
   * 此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
   */
  static ExecutorService pool = Executors.newSingleThreadExecutor();


  public static void main(String[] args) {

    System.out.println("早上：");
    System.out.println("产品经理来上班了");
    System.out.println("测试人员来上班了");
    System.out.println("开发人员来上班了");
    System.out.println("领导吩咐:");
    System.out.println("首先，产品经理规划新需求...");
    pool.submit(()->{
      System.out.println("产品经理规划新需求...");
    });
    System.out.println("然后，开发人员开发新需求功能...");
    pool.submit(()->{
      System.out.println("开发人员开发新需求功能...");
    });
    System.out.println("最后，测试人员测试新功能...");
    pool.submit(()->{
      System.out.println("测试人员测试新功能...");
    });
    pool.shutdown();
  }

}
