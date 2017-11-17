package cn.sp.t6;

/**
 * Created by 2YSP on 2017/11/17.
 * 多生产者与多消费者
 */
public class Test2 {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        P p = new P(stack);
        P pa = new P(stack);
        P pb = new P(stack);
        P pc = new P(stack);
        P_Thread pt = new P_Thread(p);
        P_Thread p2 = new P_Thread(pa);
        P_Thread p3 = new P_Thread(pb);
        P_Thread p4 = new P_Thread(pc);
        pt.start();
        p2.start();
        p3.start();
        p4.start();

        C c = new C(stack);
        C ca = new C(stack);
        C cb = new C(stack);
        C cc = new C(stack);
        C cd = new C(stack);
        C_Thread c1 = new C_Thread(c);
        C_Thread c2 = new C_Thread(ca);
        C_Thread c3 = new C_Thread(cb);
        C_Thread c4 = new C_Thread(cc);
        C_Thread c5 = new C_Thread(cd);
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
