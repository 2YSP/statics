package cn.sp.imagelogo;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by 2YSP on 2018/10/8.
 */
public class Test {
    public static void main(String[] args)throws Exception {
        URL url = new URL("https://obs.myhwclouds.com/ya89soshla6s4uma-ims-example-cn-north-1/example.jpg?x-image-process=image/sharpen,100/blur,r_1,s_1");
        URLConnection connection = url.openConnection();
        connection.setReadTimeout(3000);
        connection.setConnectTimeout(3000);
        InputStream in = connection.getInputStream();
//        OutputStream out = new FileOutputStream(new File(""));
        OutputStream out = Files.newOutputStream(Paths.get("E:/example22.jpg"));
        byte[] buffer = new byte[1024*1024];
        int len = -1;
        while ( (len = in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        Thread.sleep(1000);
        Font font = new Font("微软雅黑", Font.PLAIN, 35);                     //水印字体
        String srcImgPath="E:/example22.jpg"; //源图片地址
        String tarImgPath="E:/example22.jpg"; //待存储的地址
        String waterMarkContent="图片来源";  //水印内容
        Color color=new Color(255,255,255,128);                               //水印图片色彩以及透明度
        WaterMarkUtils.addWaterMark(srcImgPath, tarImgPath, waterMarkContent,color ,font);
        System.out.println("ok");
    }
}
