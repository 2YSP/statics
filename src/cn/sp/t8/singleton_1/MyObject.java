package cn.sp.t8.singleton_1;

/**
 * Created by 2YSP on 2017/12/5.
 * 延迟加载/“懒汉模式”
 * 缺点：在多线程环境中，不能实现保持单例的状态
 */
public class MyObject {
    private static MyObject myObject;

    private MyObject(){

    }

    public static MyObject getInstance(){
        if (myObject != null){

        }else {
            //创建对象前的准备工作
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myObject = new MyObject();
        }
        return myObject;
    }
}
