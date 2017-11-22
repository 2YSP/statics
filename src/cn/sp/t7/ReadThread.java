package cn.sp.t7;

import java.io.PipedInputStream;

/**
 * Created by 2YSP on 2017/11/22.
 */
public class ReadThread extends Thread {

    private ReadData readData;
    private PipedInputStream input;

    public ReadThread(ReadData readData,PipedInputStream input){
        this.readData = readData;
        this.input = input;
    }
    @Override
    public void run() {
        try {
            readData.readMethod(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
