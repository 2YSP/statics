package cn.sp.t8.singleton_9;

/**
 * Created by 2YSP on 2017/12/5.
 * 使用静态代码块设计单例模式
 * 省略使用enum实现单例
 */
public class MyObject {

    private static MyObject instance;

    static {
        instance = new MyObject();
    }

    private MyObject(){

    }

    public static MyObject getInstance(){
        return instance;
    }
}
