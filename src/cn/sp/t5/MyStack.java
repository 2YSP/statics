package cn.sp.t5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2YSP on 2017/11/14.
 * 最多一个
 */
public class MyStack {
    private List list = new ArrayList<>();

    /**
     * 入栈
     */
    public synchronized void push(){
        try {
            if (list.size() == 1){
                this.wait();
            }
            list.add("anyString="+Math.random());
            this.notify();
            System.out.println("push="+list.size());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 出栈
     */
    public synchronized String prop(){
        String returnValue = "";
        try {
            if (list.size() == 0){
                System.out.println("pop操作中的"+Thread.currentThread().getName()+"线程呈wait状态");
                this.wait();
            }
            returnValue = list.get(0) + "";
            list.remove(0);
            this.notify();
            System.out.println("prop="+list.size());
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnValue;
    }
}
