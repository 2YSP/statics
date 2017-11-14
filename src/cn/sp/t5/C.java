package cn.sp.t5;

/**
 * Created by 2YSP on 2017/11/14.
 */
public class C {
    private MyStack myStack;

    public C(MyStack myStack){
        this.myStack = myStack;
    }

    public void propService(){
        System.out.println("pop="+myStack.prop());
    }
}
