package cn.goodman.io;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Shaun on 2017/2/9.
 */
public class FileCopy {
    private static Log log = LogFactory.getLog(FileCopy.class);

    public static void main (String args[]) {
        int count = 0;
        byte[] buffer = new byte[512];
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            /**
             * FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。
             * 使用512字节的缓冲区
             */
            fileInputStream = new FileInputStream("F:\\temp\\image.png");
            fileOutputStream = new FileOutputStream("F:\\temp\\image_copy.png");
            while ((count = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, count);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
