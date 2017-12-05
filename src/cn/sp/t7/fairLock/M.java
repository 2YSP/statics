package cn.sp.t7.fairLock;

/**
 * Created by 2YSP on 2017/12/5.
 */
public class M {

    public static void main(String[] args) {
        final Service service = new Service(false);//true 创建公平锁
        Runnable runnable = () -> {
                System.out.println("★线程" + Thread.currentThread().getName() + "运行了");
                service.serviceMethod();
        };

        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}
