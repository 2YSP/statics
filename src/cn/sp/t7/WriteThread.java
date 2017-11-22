package cn.sp.t7;

import java.io.PipedOutputStream;

/**
 * Created by 2YSP on 2017/11/22.
 */
public class WriteThread extends Thread {

    private WriteData writeData;
    private PipedOutputStream out;

    public WriteThread(WriteData writeData,PipedOutputStream out){
        this.writeData = writeData;
        this.out = out;
    }

    @Override
    public void run() {
        writeData.writeMethod(out);
    }
}
