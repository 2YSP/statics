package cn.sp.sort;

/**
 * Created by 2YSP on 2019/4/21.
 */
public class BubbleSort {
    /**
     * 原理：比较两个相邻的元素，将值大的元素交换至右端。
     * <p>
     * 思路：依次比较相邻的两个数，将小数放在前面，大数放在后面。即在第一趟：首先比较第1个和第2个数，
     * 将小数放前，大数放后。然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，
     * 将小数放前，大数放后。重复第一趟步骤，直至全部排序完成。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 9, 11, 7, 23, 12};

        int[] sort = bubbleSort(a);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i] + ",");
        }
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {//
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
