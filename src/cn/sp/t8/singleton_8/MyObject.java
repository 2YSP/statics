package cn.sp.t8.singleton_8;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by 2YSP on 2017/12/5.
 * 序列化与反序列化的单例模式实现
 */
public class MyObject implements Serializable {

    private static class MyObjectHandler{
        private static MyObject myObject = new MyObject();
    }

    private MyObject(){

    }

    public static MyObject getInstance(){
        return MyObjectHandler.myObject;
    }

//    protected Object readResolve()throws ObjectStreamException{
//        System.out.println("调用了readResolve方法!");
//        return MyObjectHandler.myObject;
//    }
}
