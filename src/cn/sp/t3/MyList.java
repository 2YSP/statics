package cn.sp.t3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2YSP on 2017/11/13.
 */
public class MyList {
    private volatile List list = new ArrayList<>();

    public void add(){
        list.add("高红岩");
    }

    public int size(){
        return list.size();
    }
}
