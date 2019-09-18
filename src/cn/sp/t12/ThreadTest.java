package cn.sp.t12;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 2YSP on 2019/9/18.
 */
public class ThreadTest {

  /**
   * 三个线程按顺序打印'A''B''C'，循环10次
   */
  public static void main(String[] args) throws Exception{

    for (int i = 0; i < 10; i++) {
      CountDownLatch c1 = new CountDownLatch(1);
      CountDownLatch c2 = new CountDownLatch(1);
      final Thread thread1 = new Thread(() -> {
        System.out.println("A");
        c1.countDown();
      });

      final Thread thread2 = new Thread(() -> {
        try {
          //等待c1倒计时，计时为0则往下运行
          c1.await();
          System.out.println("B");
          c2.countDown();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      });

      final Thread thread3 = new Thread(() -> {
        try {
          //等待c2倒计时，计时为0则往下运行
          c2.await();
          System.out.println("C");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      });
      thread1.start();
      thread2.start();
      thread3.start();
      Thread.sleep(1000);
    }
  }
}
