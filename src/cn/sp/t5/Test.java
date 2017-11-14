package cn.sp.t5;

/**
 * Created by 2YSP on 2017/11/14.
 * 一生成与一消费:操作栈
 */
public class Test {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        P p = new P(stack);
        C c = new C(stack);
        P_Thread pt = new P_Thread(p);
        pt.start();
        C_Thread ct = new C_Thread(c);
        ct.start();
    }
}
