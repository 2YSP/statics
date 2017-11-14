package cn.sp.volatile1;

/**
 * Created by 2YSP on 2017/11/13.
 */
public class RunThread extends Thread {
    private volatile boolean isRunning = true;//加入volatile后可以正确停止

    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
    @Override
    public void run() {
        privateString();
    }

    public void privateString(){
        System.out.println("run 进入了");
        while (isRunning){

        }
        System.out.println("线程被停止了");
    }
}
