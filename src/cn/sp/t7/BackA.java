package cn.sp.t7;

/**
 * Created by 2YSP on 2017/11/22.
 */
public class BackA extends Thread {
    private DbTools dbTools;

    public BackA(DbTools dbTools){
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backA();
    }
}
