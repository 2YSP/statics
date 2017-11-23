package cn.sp.t7.join;

/**
 * Created by 2YSP on 2017/11/23.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            int secondValue = (int)(Math.random()*10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
