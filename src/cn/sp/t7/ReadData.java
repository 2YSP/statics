package cn.sp.t7;

import java.io.PipedInputStream;

/**
 * Created by 2YSP on 2017/11/22.
 */
public class ReadData {

    public void readMethod(PipedInputStream inputStream)throws Exception{
        System.out.println("read:");
        byte[] byteArray = new byte[20];
        int readLength = inputStream.read(byteArray);
        while (readLength != -1){
            String newData = new String(byteArray,0,readLength);
            System.out.print(newData);
            //继续读取流
            readLength = inputStream.read(byteArray);
        }
        System.out.println();
        inputStream.close();
    }
}
