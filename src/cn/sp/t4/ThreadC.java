package cn.sp.t4;

/**
 * Created by 2YSP on 2017/11/14.
 */
public class ThreadC extends Thread {
    private C c;

    public ThreadC(C c){
        this.c = c;
    }

    @Override
    public void run() {
        while (true){
            c.getValue();
        }
    }
}
