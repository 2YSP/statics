package cn.sp.t6;

/**
 * Created by 2YSP on 2017/11/14.
 * 一生成与多消费--操作栈:解决wait条件改变与假死
 */
public class Test {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        P p = new P(stack);

        P_Thread pt = new P_Thread(p);
        pt.start();
        C c = new C(stack);
        C ca = new C(stack);
        C cb = new C(stack);
        C cc = new C(stack);
        C cd = new C(stack);
        C_Thread ct = new C_Thread(c);
        C_Thread c2 = new C_Thread(ca);
        C_Thread c3 = new C_Thread(cb);
        C_Thread c4 = new C_Thread(cc);
        C_Thread c5 = new C_Thread(cd);
        ct.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }

    /******多生产者一消费者******/
//    public static void main(String[] args) {
//        MyStack stack = new MyStack();
//        P p = new P(stack);
//        P p11 = new P(stack);
//        P p22 = new P(stack);
//        P p33 = new P(stack);
//        P p44 = new P(stack);
//
//        P_Thread pt = new P_Thread(p);
//        P_Thread p1 = new P_Thread(p11);
//        P_Thread p2 = new P_Thread(p22);
//        P_Thread p3 = new P_Thread(p33);
//        P_Thread p4 = new P_Thread(p44);
//        pt.start();
//        p1.start();
//        p2.start();
//        p3.start();
//        p4.start();
//        C c = new C(stack);
//        C_Thread ct = new C_Thread(c);
//        ct.start();
//    }
}
