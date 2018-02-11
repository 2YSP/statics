package cn.sp.jdk_8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 2YSP
 * @Description: 流的扁平化
 * @Date: Created in 2018/2/11
 */
public class FlatMap {

    public static void main(String[] args) {
        /**筛选出不同的字符**/
        String[] words = {"Hello", "World"};
        List<String> uniqueCharacters = Arrays.stream(words)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream) //可以将单个流合并起来
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCharacters);
        /**找出和能被3整除的整数对**/
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        List<int[]> pairs = number1.stream()
                .flatMap(i ->
                        number2.stream()
                                .filter(j -> (j + i) % 3 == 0)
                                .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());
        for (int[] a : pairs) {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            for (int i = 0; i < a.length; i++) {
                sb.append(a[i]);
                if (i != a.length - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb.toString());
        }

        /**归约**/
        Integer sum = number1.stream()
                .reduce(0, Integer::sum);
        System.out.println("整数和为：" + sum);
    }
}
