package cn.sp.t4;

/**
 * Created by 2YSP on 2017/11/14.
 * 一生成与一消费：操作值
 */
public class Test {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        ThreadP p1 = new ThreadP(p);
        p1.start();
        ThreadC c1 = new ThreadC(c);
        c1.start();
    }
}
