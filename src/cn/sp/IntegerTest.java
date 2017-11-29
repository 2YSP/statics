package cn.sp;

import java.lang.reflect.Field;

/**
 * Created by 2YSP on 2017/11/29.
 * Integer 类-128~127 具有缓存，不会生成新的对象
 * == 比较内存地址和值，equals()比较值。
 * Integer a = 1;Integer b = 1;System.out.println(a == b);//输出true
 * Integer a = 128;Integer b = 128;System.out.println(a == b);//输出false
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.println("a="+a+" b="+b);
        swap(a,b);
        System.out.println("a="+a+" b="+b);
    }

    private static void swap(Integer num1, Integer num2) {

        try {
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            int temp = num1.intValue();
            value.set(num1,num2);
            value.set(num2,new Integer(temp));//或者主动new，不走自动装箱
//            value.setInt(num1,num2);//setInt,不产生装箱和拆箱
//            value.setInt(num2,temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
