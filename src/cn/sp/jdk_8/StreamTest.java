package cn.sp.jdk_8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Author: 2YSP
 * @Description:
 * @Date: Created in 2018/2/9
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("dapanji",1000),new Dish("egg",500),
                new Dish("tomoto",600),new Dish("apple",660));

//        List<String> dishNames = menu.stream()
//                .filter(dish -> dish.getCalories() < 700)// 选出700卡路里以下的菜肴
//                .sorted(Comparator.comparing(Dish::getName)) // 按名称排序
//                .map(Dish::getName) //提取名称
//                .collect(toList()); //将所有名称保存到List
//        System.out.println(dishNames);
        List<Dish> list = menu.stream()
                .sorted(Comparator.comparing(Dish::getCalories))
                .collect(toList());
        System.out.println(list);
    }
}
