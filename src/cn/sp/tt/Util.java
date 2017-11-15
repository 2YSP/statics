package cn.sp.tt;

import java.util.*;

/**
 * Created by 2YSP on 2017/11/15.
 */
public class Util {
    public static Map<String, List<Map<String, Object>>> transfer(List<Map<String, Object>> list) {
        Map<String, List<Map<String, Object>>> resultMap = new HashMap<>();
        List<Map<String, Object>> aList = new ArrayList<>();
        List<Map<String, Object>> bList = new ArrayList<>();
        List<Map<String, Object>> cList = new ArrayList<>();
        //取出所有的值
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> m = list.get(i);
            Iterator<Map.Entry<String, Object>> iterator = m.entrySet().iterator();
            while (iterator.hasNext()) {
                Map<String, Object> map = new HashMap<>();
                Map.Entry<String, Object> entry = iterator.next();
                map.put(entry.getKey(), entry.getValue());
                //分组
                if ("a".equals(entry.getKey())) {
                    aList.add(map);
                } else if ("b".equals(entry.getKey())) {
                    bList.add(map);
                } else if ("c".equals(entry.getKey())) {
                    cList.add(map);
                }
            }
        }
        //再排序
       Collections.sort(aList, new Comparator<Map<String, Object>>() {
           @Override
           public int compare(Map<String, Object> o1, Map<String, Object> o2) {
               Integer a1 = Integer.valueOf(o1.get("a") + "");
               Integer a2 = Integer.valueOf(o2.get("a") + "");

               if (a1 > a2){
                   return 1;
               }else if (a1 < a2){
                   return -1;
               }
               return 0;
           }
       });
        Collections.sort(bList, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer b1 = Integer.valueOf(o1.get("b") + "");
                Integer b2 = Integer.valueOf(o2.get("b") + "");

                if (b1 > b2){
                    return 1;
                }else if (b1 < b2){
                    return -1;
                }
                return 0;
            }
        });
        Collections.sort(cList, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer c1 = Integer.valueOf(o1.get("c") + "");
                Integer c2 = Integer.valueOf(o2.get("c") + "");

                if (c1 > c2){
                    return 1;
                }else if (c1 < c2){
                    return -1;
                }
                return 0;
            }
        });
//        System.out.println(aList);
//        System.out.println(bList);
//        System.out.println(cList);

        resultMap.put("a",aList);
        resultMap.put("b",bList);
        resultMap.put("c",cList);
        return resultMap;
    }

    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList(){{
           add(new HashMap(){{put("a",11);put("c",3);}});
           add(new HashMap(){{put("a",1);put("b",2);}});
           add(new HashMap(){{put("a",111);put("c",1);}});
           add(new HashMap(){{put("b",22);}});
           add(new HashMap(){{put("a",1111);put("b",222);}});
        }};
        System.out.println("之前："+list);
        Map<String, List<Map<String, Object>>> resultMap = transfer(list);
        System.out.println("之后："+resultMap);
    }
//    public static void main(String[] args) {
//        Map<String, List<Map<String, Object>>> map = new HashMap<>();
//        List<Map<String, Object>> list1 = new ArrayList<>();
//        List<Map<String, Object>> list2 = new ArrayList<>();
//        List<Map<String, Object>> list3 = new ArrayList<>();
//        Map<String, Object> a1 = new HashMap<>();
//        a1.put("a", 1111);
//        list1.add(a1);
//        Map<String, Object> a2 = new HashMap<>();
//        a2.put("a", 111);
//        list1.add(a2);
//        Map<String, Object> a3 = new HashMap<>();
//        a3.put("a", 11);
//        list1.add(a3);
//
//
//        Map<String, Object> b1 = new HashMap<>();
//        b1.put("b", 2222);
//        list2.add(b1);
//        Map<String, Object> b2 = new HashMap<>();
//        b2.put("b", 222);
//        list2.add(b2);
//        Map<String, Object> b3 = new HashMap<>();
//        b3.put("b", 22);
//        list2.add(b3);
//
//        Map<String, Object> c1 = new HashMap<>();
//        c1.put("c", 3);
//        list3.add(c1);
//        Map<String, Object> c2 = new HashMap<>();
//        c2.put("c", 1);
//        list3.add(c2);
//
//        map.put("a", list1);
//        map.put("b", list2);
//        map.put("c", list3);
//        System.out.println(map);
//
//    }
}
