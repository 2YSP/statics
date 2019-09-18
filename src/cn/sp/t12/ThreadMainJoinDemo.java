package cn.sp.t12;

/**
 * Created by 2YSP on 2019/9/18.
 */
public class ThreadMainJoinDemo {

  public static void main(String[] args) throws Exception{
    final Thread thread1 = new Thread(() -> {
      System.out.println("产品经理规划新需求");
    });

    final Thread thread2 = new Thread(() -> {
      System.out.println("开发人员开发新需求功能");
    });

    final Thread thread3 = new Thread(()->{
      System.out.println("测试人员测试新功能");
    });


    System.out.println("早上：");
    System.out.println("测试人员来上班了...");
    System.out.println("产品经理来上班了...");
    System.out.println("开发人员来上班了...");

    thread1.start();
    // 在父进程调用子进程的join()方法后，父进程需要等待子进程运行完再继续运行。
    System.out.println("开发人员和测试人员休息会...");
    thread1.join();
    System.out.println("产品经理新需求规划完成!");
    thread2.start();
    System.out.println("测试人员休息会...");
    thread2.join();

    thread3.start();
  }

}
