package cn.sp.t2;

/**
 * Created by 2YSP on 2017/11/8.
 * 线程的中断--抛异常法
 * break:循环后的代码还会执行
 * throw new InterruptedException：循环后的代码不再执行
 */
public class MyThread extends Thread {

    @Override
    public void run() {
//        try{
            for (int i=0;i<500000;i++){
                if (this.interrupted()){
                    System.out.println("已经是停止状态了，我要退出！");
                    break;
//                    throw new InterruptedException();
                }
                System.out.println("i="+(i+1));
            }
            System.out.println("我在for下面");
//        }catch (InterruptedException e){
//            System.out.println("进Mythread.java类run方法的catch中了");
//            e.printStackTrace();
//        }

    }

    public static void main(String[] args) throws Exception{
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.sleep(2000);
        myThread.interrupt();
    }
}
