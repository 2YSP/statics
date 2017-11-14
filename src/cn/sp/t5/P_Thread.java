package cn.sp.t5;

/**
 * Created by 2YSP on 2017/11/14.
 */
public class P_Thread extends Thread {
    private P p;

    public P_Thread(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true){
            p.pushService();
        }
    }
}
