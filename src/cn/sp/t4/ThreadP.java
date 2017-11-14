package cn.sp.t4;

/**
 * Created by 2YSP on 2017/11/14.
 */
public class ThreadP extends Thread{
    private P p;

    public ThreadP(P p){
        this.p = p;
    }

    @Override
    public void run() {
        while (true){
            p.setValue();
        }

    }
}
