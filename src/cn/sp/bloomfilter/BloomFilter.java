package cn.sp.bloomfilter;

/**
 * 布隆过滤算法的简单实现
 * Created by 2YSP on 2019/4/19.
 */
public class BloomFilter {

    private int arraySize;

    private int[] array;

    public BloomFilter(int arraySize){
        this.arraySize = arraySize;
        array = new int[arraySize];
    }


    /**
     * 写入数据
     * @param key
     */
    public void add(String key){
        int first = hashCode_1(key);
        int second = hashCode_2(key);
        int third = hashCode_3(key);

        array[first % arraySize] = 1;
        array[second % arraySize] = 1;
        array[third % arraySize] = 1;
    }

    /**
     * 检查数据是否存在
     * @param key
     * @return
     */
    public boolean check(String key){
        int first = hashCode_1(key);
        int second = hashCode_2(key);
        int third = hashCode_3(key);

        int firstIndex = array[first % arraySize];
        if (firstIndex == 0){
            return false;
        }

        int secondIndex = array[second % arraySize];
        if (secondIndex == 0){
            return false;
        }

        int thirdIndex = array[third % arraySize];
        if (thirdIndex == 0){
            return false;
        }
        return true;
    }

    private int hashCode_3(String key) {
        int hash, i;
        for (hash = 0, i = 0; i < key.length(); ++i) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash);
    }

    private int hashCode_2(String data) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < data.length(); i++) {
            hash = (hash ^ data.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);

    }

    private int hashCode_1(String key) {
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i) {
            hash = 33 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BloomFilter bloomFilter = new BloomFilter(10000000);
        for(int i=0;i<10000000;i++){
            bloomFilter.add(i + "");
        }

        System.out.println(bloomFilter.check(1+""));
        System.out.println(bloomFilter.check(2+""));
        System.out.println(bloomFilter.check(3+""));
        System.out.println(bloomFilter.check(9999999+""));
        System.out.println(bloomFilter.check(400230340+""));

        long end = System.currentTimeMillis();
        System.out.println("执行时间: "+(end - start));
    }


}
