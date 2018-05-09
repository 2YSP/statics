package cn.sp;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: 2YSP
 * @Description: 7 TWR特性
 * @Date: Created in 2018/5/9
 */
public final class FileCopy {

    // 工具类中的方法都是静态方式访问的因此将构造器私有不允许创建对象(绝对好习惯)
    private FileCopy(){
        throw new AssertionError();
    }


    public static void fileCopyNIO(String resource,String target)throws IOException{
        try(FileInputStream in = new FileInputStream(resource)){
                try(FileOutputStream out = new FileOutputStream(target)){
                    FileChannel inChannel = in.getChannel();
                    FileChannel outChannel = out.getChannel();
                    ByteBuffer buffer = ByteBuffer.allocate(4096);
                    while ((inChannel.read(buffer))!= -1){
                        buffer.flip();
                        outChannel.write(buffer);
                        buffer.clear();
                    }
                }   
        }
    }

    public static void main(String[] args)throws Exception {
        FileCopy.fileCopyNIO("E:\\jad.zip","E:\\aa.zip");
    }
}
