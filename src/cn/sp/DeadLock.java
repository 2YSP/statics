package cn.sp;


import java.util.concurrent.CountDownLatch;

/**
 * Created by 2YSP on 2019/4/20.
 */
public class DeadLock {

    public static void main(String[] args) {
        String lockA = "a";
        String lockB = "b";
        final CountDownLatch startGate = new CountDownLatch(1);
        Thread t1 = new DeadLockThread(lockA,lockB,startGate);
        Thread t2 = new DeadLockThread(lockB,lockA,startGate);
        t1.start();
        t2.start();
        startGate.countDown();
    }

    private static class DeadLockThread extends Thread{

        private String lockA;
        private String lockB;
        private CountDownLatch gate;

        public DeadLockThread(String lockA,String lockB,CountDownLatch gate){
            this.lockA = lockA;
            this.lockB = lockB;
            this.gate = gate;
        }

        @Override
        public void run() {
            synchronized (lockA){
                System.out.println(Thread.currentThread().getName()+"=========");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                try {
                    gate.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB){
                    System.out.println("=========");
                }
            }
        }
    }
}
