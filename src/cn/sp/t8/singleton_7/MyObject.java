package cn.sp.t8.singleton_7;

/**
 * Created by 2YSP on 2017/12/5.
 * 使用静态内置类实现单例模式
 */
public class MyObject {
    private static class MyObjectHandler{
        private static MyObject myObject = new MyObject();
    }

    private MyObject(){

    }

    public static MyObject getInstance(){
        return MyObjectHandler.myObject;
    }
}
