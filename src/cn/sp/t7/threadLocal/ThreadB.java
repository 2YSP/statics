package cn.sp.t7.threadLocal;

import java.util.Date;

/**
 * Created by 2YSP on 2017/11/23.
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        try{
            for(int i =0 ;i<20;i++){
                if (Tools.t1.get() == null){
                    Tools.t1.set(new Date());
                }

                System.out.println("threadB get :"+Tools.t1.get().getTime());
                Thread.sleep(100);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
