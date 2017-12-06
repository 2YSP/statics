package cn.sp.guavaCache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by 2YSP on 2017/12/6.
 */
public class CacheTest {

    final static Cache<Integer,String> cache = CacheBuilder.newBuilder()
            //设置初始大小
            .initialCapacity(10)
            //设置并发数为5，即同一时间最多只能有5个线程往cache执行写操作
            .concurrencyLevel(5)
            //写之后的存活时间
            .expireAfterWrite(10, TimeUnit.SECONDS)
            .build();

    public static void main(String[] args) throws Exception{

        cache.put(1,"hi");

        for(int i= 0;i<100;i++){
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            System.out.println(sdf.format(new Date())+"key:1,value:"+cache.getIfPresent(1));

            Thread.sleep(1000);
        }
    }
}
