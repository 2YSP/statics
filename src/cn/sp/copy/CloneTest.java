package cn.sp.copy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象深拷贝和浅拷贝测试
 * Created by 2YSP on 2019/4/16.
 */
public class CloneTest {


    public static void main(String[] args)throws Exception {
        Son father = new Son();
        father.setName("LiLiu");
        Son son = new Son();
        son.setName("LiWu");
        Son grandSon = new Son();
        grandSon.setName("LiLiu");
        father.setSon(son);
        son.setSon(grandSon);
        //调用clone方法  浅拷贝
        Son fatherCopy = father.clone();
        // 比较克隆后的地址
        System.out.println(fatherCopy == father); //false
        System.out.println(fatherCopy.getSon() == son);// true
        System.out.println(fatherCopy.getSon().getSon() == grandSon); // true

        //比较name
        System.out.println(fatherCopy.getName() == father.getName());   // true
        System.out.println(fatherCopy.getSon().getName() == son.getName());// true
        System.out.println(fatherCopy.getSon().getSon().getName() == grandSon.getName()); // true
        /**********深拷贝*********/
        //对象写到流里
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(outputStream);
        objOut.writeObject(father);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objIn = new ObjectInputStream(byteIn);
        fatherCopy = (Son) objIn.readObject();
        System.out.println();
        // 比较克隆后的地址
        System.out.println(fatherCopy == father); //false
        System.out.println(fatherCopy.getSon() == son);// false
        System.out.println(fatherCopy.getSon().getSon() == grandSon); // false

        //比较name
        System.out.println(fatherCopy.getName() == father.getName());   // false
        System.out.println(fatherCopy.getSon().getName() == son.getName());// false
        System.out.println(fatherCopy.getSon().getSon().getName() == grandSon.getName()); // false
    }
}
