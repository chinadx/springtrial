package cn.goodman.io;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by Shaun on 2017/2/9.
 */
public class FileExample {
    private static Log log = LogFactory.getLog(FileExample.class);

    public static void main(String args[]) {
        createFile();
    }

    public static void createFile() {
        File file = new File("F:\\temp\\FileExample.txt");
        try {
            file.createNewFile();
            log.info("该分区大小为：" + file.getTotalSpace()/(1024*1024*1024) + "G");
            file.mkdirs();
            log.info("文件名：" + file.getName());
            log.info("父目录名：" + file.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
