package cn.sp.t7;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by 2YSP on 2017/11/22.
 * 管道间的进程通信：字节流
 */
public class Test {

    public static void main(String[] args) throws Exception{
        ReadData readData = new ReadData();
        WriteData writeData = new WriteData();

        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();

//        inputStream.connect(outputStream);//使两个stream之间产生通信连接
        outputStream.connect(inputStream);

        ReadThread readThread = new ReadThread(readData, inputStream);
        readThread.start();
        Thread.sleep(2000);

        WriteThread writeThread = new WriteThread(writeData, outputStream);
        writeThread.start();
    }
}
