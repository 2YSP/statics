package cn.sp.t7;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created by 2YSP on 2017/11/22.
 */
public class WriteData {

    public void writeMethod(PipedOutputStream outputStream){
        try {
            System.out.println("write:");
            for(int i = 1 ; i<300;i++){
                String anyString = ""+i;
                outputStream.write(anyString.getBytes());
                System.out.print(anyString);
            }
            System.out.println();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
