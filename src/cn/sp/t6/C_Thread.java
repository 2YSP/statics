package cn.sp.t6;

/**
 * Created by 2YSP on 2017/11/14.
 */
public class C_Thread extends Thread {
    private C c;

    public C_Thread(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true){
            c.propService();
        }
    }
}
