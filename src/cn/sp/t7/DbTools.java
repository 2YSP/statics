package cn.sp.t7;

/**
 * Created by 2YSP on 2017/11/22.
 */
public class DbTools {

    volatile private boolean prevIsA = false;

    public synchronized void backA(){
        try{
            while (prevIsA == true){
                wait();
            }
            for(int i = 0;i<5;i++){
                System.out.println("★★★★★");
            }
            prevIsA = true;
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void backB(){
        try{
            while (prevIsA == false){
                wait();
            }
            for(int i = 0;i<5;i++){

                System.out.println("☆☆☆☆☆");
            }
            prevIsA = false;
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
