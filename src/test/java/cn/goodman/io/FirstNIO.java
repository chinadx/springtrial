package cn.goodman.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Shaun on 2017/2/17.
 * NIO处理三部曲：
 * 1.Channel.read读入到缓冲区
 * 2.Buffer.flip切换到读模式
 * 3.Buffer.get获取缓冲区的数据
 * 缓冲区满时需要调用clear或compact清空
 */
public class FirstNIO {
    public static void main(String[] args) {
        RandomAccessFile accessFile = null;
        try {
            accessFile = new RandomAccessFile("F:\\temp\\nio-data.txt", "rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer bf = ByteBuffer.allocate(32);
            int bytesRead = fileChannel.read(bf);

            while(bytesRead != -1) {
                bf.flip();
                while (bf.hasRemaining()) {
                    System.out.print((char) bf.get());
                }
                bf.compact();
                bytesRead = fileChannel.read(bf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                accessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
