package cn.sp.t1;

/**
 * Created by 2YSP on 2017/11/8.
 */
public class CountOperate extends Thread {

    public  CountOperate(){
        System.out.println("CountOperate ------ begin");
        System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
        System.out.println("this.getName()="+this.getName());
        System.out.println("CountOperate ------ end");

    }

    @Override
    public void run() {
        System.out.println("run ----- begin");
        System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
        System.out.println("this.getName()="+this.getName());
        System.out.println("run ----- end");
    }
}
