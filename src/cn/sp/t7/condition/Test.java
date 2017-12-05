package cn.sp.t7.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 2YSP on 2017/12/5.
 * 使用condition 顺序执行
 */
public class Test {
    volatile public static int nextPrintWho = 1;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            try {
                lock.lock();
                while (nextPrintWho != 1) {
                    conditionA.await();
                }
                nextPrintWho = 2;
                for (int i = 0; i < 3; i++) {
                    System.out.println("ThreadA: " + (i + 1));
                }
                conditionA.signalAll();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                lock.lock();
                while (nextPrintWho != 2) {
                    conditionB.await();
                }
                nextPrintWho = 3;
                for (int i = 0; i < 3; i++) {
                    System.out.println("ThreadB: " + (i + 1));
                }
                conditionB.signalAll();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                lock.lock();
                while (nextPrintWho != 3) {
                    conditionC.await();
                }
                nextPrintWho = 1;
                for (int i = 0; i < 3; i++) {
                    System.out.println("ThreadC: " + (i + 1));
                }
                conditionC.signalAll();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        });

        Thread[] aArray = new Thread[5];
        Thread[] bArray = new Thread[5];
        Thread[] cArray = new Thread[5];
        for (int i = 0; i < 5; i++) {
            aArray[i] = new Thread(threadA);
            bArray[i] = new Thread(threadB);
            cArray[i] = new Thread(threadC);
            aArray[i].start();
            bArray[i].start();
            cArray[i].start();
            System.out.println("======================");
        }


    }
}
