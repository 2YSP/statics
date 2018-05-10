package cn.sp;

import java.util.Comparator;

/**
 * @Author: 2YSP
 * @Description: 实现折半查找算法
 * @Date: Created in 2018/5/10
 */
public class MyUtil {

    /**
     * 使用循环实现
     * @param list
     * @param key
     * @param comp
     * @param <T>
     * @return
     */
    public static <T> int binarySearch(T[] list, T key, Comparator<T> comp){
        int low = 0;
        int high = list.length - 1;
        while (low <= high){
            int mid = (low+high) >>> 1;
            if (comp.compare(list[mid],key) > 0){
                high = mid - 1;
            }else if (comp.compare(list[mid],key) < 0){
                low = mid + 1;
            }else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 使用递归实现
     * @param list
     * @param low
     * @param high
     * @param key
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int binarySearch(T[] list,int low,int high,T key){
        if (low <= high){
            int mid = (low+high) >>> 1;
            if (list[mid].compareTo(key) > 0){
                high = mid - 1;
                binarySearch(list,low,high,key);
            }else if (list[mid].compareTo(key) < 0){
                low = mid + 1;
                binarySearch(list,low,high,key);
            }else {
                return mid;
            }
        }
        return -1;
    }

    public  static <T extends Comparable<T>> int binarySearch(T[] list,T key){
        return binarySearch(list,0,list.length-1,key);
    }

    public static void main(String[] args) {
        Integer[] list = {1,3,5,8,10};
        Integer key = 7;
        int result = binarySearch(list,key);
        System.out.println(result);
    }
}
