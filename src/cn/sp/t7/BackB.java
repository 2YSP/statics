package cn.sp.t7;

/**
 * Created by 2YSP on 2017/11/22.
 */
public class BackB extends Thread {
    private DbTools dbTools;

    public BackB(DbTools dbTools){
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backB();
    }
}
