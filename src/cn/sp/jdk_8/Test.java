package cn.sp.jdk_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @Author: 2YSP
 * @Description:
 * @Date: Created in 2018/2/9
 */
public class Test {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple("green",80),
                new Apple("red",155),new Apple("red",120),new Apple("green",120));
        //选出绿色的苹果
        List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples);
        //选出重量大于150g的苹果,以下三种方法都可以
        List<Apple> heavyApples = filter(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples);
        //按重量升序排序
//        inventory.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight().compareTo(o2.getWeight());
//            }
//        });
//        inventory.sort((Apple a1,Apple a2)-> a1.getWeight().compareTo(a2.getWeight()));
//        inventory.sort(Comparator.comparing(Apple::getWeight));
        /**先按重量降序，再颜色排序**/
        inventory.sort(Comparator
                        .comparing(Apple::getWeight)
                        .reversed()
                        .thenComparing(Apple::getColor));
        /**复合函数，输出4**/
        Function<Integer,Integer> f = x -> x+1;
        Function<Integer,Integer> g = x -> x*2;
        Function<Integer,Integer> h = f.andThen(g);
        Integer result = h.apply(1);
        System.out.println(result);
    }


    public static <T> List<T> filter(List<T> list,Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e : list){
            if (p.test(e)){
                result.add(e);
            }
        }
        return result;
    }
}
