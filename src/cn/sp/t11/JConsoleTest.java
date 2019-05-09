package cn.sp.t11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2YSP on 2019/3/31.
 */
public class JConsoleTest {
    /**
     *
     * 内存占位符对象，一个大约64KB
     */
    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }


    public static void main(String[] args)throws Exception {
//        fillHeap(1000);
//        createBusyThread();

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);// true
        System.out.println(e == f); // false
        System.out.println(c == (a + b)); //比较值 true
        System.out.println(c.equals(a + b)); // true
        System.out.println(g == (a + b)); // true
        System.out.println(g.equals(a + b));// false,a+b返回的不是Long类型
        /**
         *
         * 反编译后代码
         *
         *
         * Integer localInteger1 = Integer.valueOf(1);
         Integer localInteger2 = Integer.valueOf(2);
         Integer localInteger3 = Integer.valueOf(3);
         Integer localInteger4 = Integer.valueOf(3);
         Integer localInteger5 = Integer.valueOf(321);
         Integer localInteger6 = Integer.valueOf(321);
         Long localLong = Long.valueOf(3L);


         System.out.println(localInteger3 == localInteger4);
         System.out.println(localInteger5 == localInteger6);
         System.out.println(localInteger3.intValue() == localInteger1.intValue() + localInteger2.intValue());
         System.out.println(localInteger3.equals(Integer.valueOf(localInteger1.intValue() + localInteger2.intValue())));
         System.out.println(localLong.longValue() == localInteger1.intValue() + localInteger2.intValue());
         System.out.println(localLong.equals(Integer.valueOf(localInteger1.intValue() + localInteger2.intValue())));
         *
         *
         */
        System.out.println(Math.round(-1.5));
        System.out.println(reverse("abcd"));
    }


    private static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for(int i = 0;i<num;i++){
            // 稍作延迟令监视曲线变化更明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    /**
     * 线程死循环演示
     */
    public static void createBusyThread(){
        Thread thread = new Thread(()->{
            while (true);
        },"testBusyThread");
        thread.start();
    }


    public static String reverse(String s){
        int length = s.length();
        if (length <= 1){
            return s;
        }
        String left = s.substring(0,length >> 1);
        String right = s.substring(length >> 1,length);
        return reverse(right) + reverse(left);
    }
}
