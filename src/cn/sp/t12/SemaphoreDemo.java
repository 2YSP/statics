package cn.sp.t12;

import java.util.concurrent.Semaphore;

/**
 * Created by 2YSP on 2019/9/18.
 */
public class SemaphoreDemo {

  private static Semaphore semaphore1 = new Semaphore(1);
  private static Semaphore semaphore2 = new Semaphore(1);

  public static void main(String[] args) {
    Thread thread1 = new Thread(() -> {
      System.out.println("产品经理规划新需求");
      semaphore1.release();
    });

    Thread thread2 = new Thread(() -> {
      try {
        semaphore1.acquire();
        System.out.println("开发人员开发新需求功能");
        semaphore2.release();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread thread3 = new Thread(() -> {
      try {
        semaphore2.acquire();
        thread2.join();
        semaphore2.release();
        System.out.println("测试人员测试新功能");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    System.out.println("早上：");
    System.out.println("测试人员来上班了...");
    thread3.start();
    System.out.println("产品经理来上班了...");
    thread1.start();
    System.out.println("开发人员来上班了...");
    thread2.start();
  }

}
