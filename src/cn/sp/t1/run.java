package cn.sp.t1;

import cn.sp.t2.MyThread;

/**
 * Created by 2YSP on 2017/11/8.
 */
public class run {
    /**输出:
     * CountOperate ------ begin
     Thread.currentThread().getName()=main
     this.getName()=Thread-0
     CountOperate ------ end
     run ----- begin
     Thread.currentThread().getName()=A
     this.getName()=Thread-0
     run ----- end
     * @param args
     */
    public static void main(String[] args)throws Exception {
//        CountOperate countOperate = new CountOperate();
//        Thread t1 = new Thread(countOperate);
//        t1.setName("A");
//        t1.start();

//        Thread.currentThread().interrupt();
//        System.out.println("是否停止1？"+Thread.interrupted());
//        System.out.println("是否停止2？"+Thread.interrupted());

        MyThread thread = new MyThread();
        thread.start();
        thread.sleep(1000);
        thread.interrupt();
        System.out.println("end");
    }
}
