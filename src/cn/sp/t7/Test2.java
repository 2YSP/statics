package cn.sp.t7;

/**
 * Created by 2YSP on 2017/11/22.
 */
public class Test2 {

    public static void main(String[] args) {
        DbTools dbTools = new DbTools();
        for (int i=0;i<20;i++){
            BackA backA = new BackA(dbTools);
            backA.start();
            BackB backB = new BackB(dbTools);
            backB.start();
        }
    }
}
