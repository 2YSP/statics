package cn.sp.t9;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: 2YSP
 * @Description: 桌面应用程序中的生产者任务
 * @Date: Created in 2018/3/2
 */
public class FileCrawler implements Runnable{

    private final BlockingQueue<File> fileQueue;

    private final FileFilter fileFilter;

    private final File root;

    public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFilter, File root) {
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    @Override
    public void run() {
        try {
            crawler(root);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void crawler(File root)throws InterruptedException {
        File[] entries = root.listFiles(fileFilter);
        if (entries != null){
            for(File entry : entries){
                if (entry.isDirectory()){
                    crawler(root);
                }else if (!alreadyIndexed(entry)){
                    fileQueue.put(entry);
                }
            }
        }
    }

    private boolean alreadyIndexed(File entry) {
        return true;
    }
}
