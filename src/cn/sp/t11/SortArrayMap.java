package cn.sp.t11;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一致性Hash算法实现
 * Created by 2YSP on 2019/3/25.
 */
public class SortArrayMap {
    /**
     * 核心数组
     */
    private Node[] buckets;

    private static final int DEFAULT_SIZE = 10;

    /**
     * 数组大小
     */
    private int size;

    public SortArrayMap(){
        buckets = new Node[DEFAULT_SIZE];
    }

    public void add(Long key,String value){
        checkSize(size+1);
        Node node = new Node(key,value);
        buckets[size++] = node;
    }

    /**
     * 检查是否需要扩容
     * @param size
     */
    private void checkSize(int size) {
        if (size >= buckets.length){
            // 扩容自身的2/3
            int oldLen = buckets.length;
            int newLen = oldLen + (oldLen >> 1);
            buckets = Arrays.copyOf(buckets,newLen);
        }
    }

    /**
     * 排序
     */
    public void sort(){
        Arrays.sort(buckets, 0, size,((o1, o2) -> {
            if (o1.key > o2.key){
                return 1;
            }else {
                return -1;
            }
        }));
    }

    /**
     * 顺时针取出数据
     * @param key
     * @return
     */
    public String firstNodeValue(long key){
        if (size == 0){
            return null;
        }
        for(Node bucket : buckets){
            if (bucket == null){
                continue;
            }
            if (bucket.key >= key){
                return bucket.value;
            }
        }
        return buckets[0].value;
    }
    private class Node{

        public Long key;
        public String value;

        public Node(Long key,String value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public void print(){
        for(Node node : buckets){
            if (node == null){
                continue;
            }
            System.out.println(node.toString());
        }
    }

    public static void main(String[] args) {
        SortArrayMap map = new SortArrayMap();
        map.add(100L,"127.0.0.100");
        map.add(10L,"127.0.0.10");
        map.add(8L,"127.0.0.8");
        map.add(1000L,"127.0.0.1000");

        map.sort();
        map.print();
        String value = map.firstNodeValue(101);
        System.out.println(value);
    }
}
