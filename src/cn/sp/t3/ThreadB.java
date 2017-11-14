package cn.sp.t3;


/**
 * Created by 2YSP on 2017/11/13.
 */
public class ThreadB extends Thread {
    private MyList list;

    public ThreadB(MyList list){
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true){
                if (list.size() == 5){
                    System.out.println("=5了，线程b要退出了");

                        throw  new InterruptedException();

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
