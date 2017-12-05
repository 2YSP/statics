package cn.sp.t8.singleton_0;

/**
 * Created by 2YSP on 2017/12/5.
 * 立即加载/"饿汉模式"
 */
public class MyObject {

    private static MyObject myObject = new MyObject();

    private MyObject(){

    }

    public static MyObject getInstance(){
        //缺点是不能有其他实例变量
        //因为getInstance()方法没有同步
        //有可能出现线程安全问题
        return myObject;
    }
}
