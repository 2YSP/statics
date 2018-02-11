package cn.sp.jdk_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 2YSP
 * @Description: jdk 1.8 forEach+  拉姆达表达式遍历
 * @Date: Created in 2018/1/3
 */
public class ForEachTest {

    public static void main(String[] args) {
        /******遍历Map*******/
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k1,v2) ->{
            System.out.println("item:"+k1+",count:"+v2);
        });
        /******遍历List*******/
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        list.forEach(item->{
            System.out.println(item);
            if ("A".equals(item)){
                System.out.println("it is A");
            }
        });

    }
}
