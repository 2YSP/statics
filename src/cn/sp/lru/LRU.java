package cn.sp.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 缓存淘汰算法--LRU算法
 * Created by 2YSP on 2019/2/23.
 */
public class LRU<K,V> {

    private static final float hashLoadFactory = 0.75f;

    private LinkedHashMap<K,V> map;

    private int cashSize;

    public LRU(int cashSize){
        this.cashSize = cashSize;
        int capacity = (int)Math.ceil(cashSize/hashLoadFactory) + 1;
        // 创建一个按照访问顺序排序的LinkedHashMap
        map = new LinkedHashMap<K,V>(capacity,hashLoadFactory,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                // 当大小超过缓存大小时就移除最不常读取的数
                return size() > LRU.this.cashSize;
            }
        };
    }

    public synchronized V get(K key){
        return map.get(key);
    }

    public synchronized void put(K key,V value){
        map.put(key,value);
    }

    public synchronized void clear(){
        map.clear();
    }

    public synchronized int usedSize(){
        return map.size();
    }

    public void print(){
        for(Map.Entry<K,V> entry : map.entrySet()){
            System.out.print(entry.getValue() + "-");
        }
        System.out.println();
    }

}
