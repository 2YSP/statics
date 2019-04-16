package cn.sp.copy;

import java.io.Serializable;

/**
 * Created by 2YSP on 2019/4/16.
 */
public class Son implements Serializable,Cloneable {

    private String name;

    private Son son;

    public Son(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }

    @Override
    public Son clone() throws CloneNotSupportedException {
        return (Son) super.clone();
    }
}
