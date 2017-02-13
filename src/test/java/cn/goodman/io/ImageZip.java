package cn.goodman.io;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.event.IIOWriteProgressListener;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Shaun on 2017/2/13.
 * 将指定目录的图片按比例压缩
 */
public class ImageZip {
    private static String path = null;
    private static String destPath = null;

    public static void listFile(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                System.out.println("这是个目录，" + file.getName());
                File[] files = file.listFiles();
                for (File f : files) {
                    listFile(f);
                }
            } else {
                System.out.print("这是个文件，" + file.getName() + "，" + file.getPath() + "，大小为：" + file.length());
                try {
                    BufferedImage bufferedImage = ImageIO.read(file);
                    int width = bufferedImage.getWidth(null);
                    int height = bufferedImage.getHeight(null);
                    System.out.println("，分辨率为：" + width + "x" + height);

                    String filepath = file.getPath();
                    String fileDir = file.getParent();

                    StringBuffer newPath = new StringBuffer();
                    newPath.append(destPath);
                    newPath.append(fileDir.substring(path.length()));
                    File f = new File(newPath.toString());
                    f.mkdirs();
                    newPath.append(File.separatorChar);
                    newPath.append(file.getName());
                    File ff = new File(newPath.toString());
                    writeJPEG(ff, bufferedImage, 50, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 保存图像到 JPEG 文件
     * @param file 保存的目标文件
     * @param image 保存的源图像
     * @param quality 保存的 JPEG 图像质量
     * @param listener 保存进度监听器
     */
    public static void writeJPEG(File file, BufferedImage image, int quality, IIOWriteProgressListener listener) throws
            FileNotFoundException, IOException {
        Iterator it = ImageIO.getImageWritersBySuffix("jpg");
        if (it.hasNext()) {
            FileImageOutputStream fileImageOutputStream = new FileImageOutputStream(file);
            ImageWriter iw = (ImageWriter) it.next();
            ImageWriteParam iwp = iw.getDefaultWriteParam();
            iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            iwp.setCompressionQuality((float) quality / 100f);
            iw.setOutput(fileImageOutputStream);
            iw.addIIOWriteProgressListener(listener);
            iw.write(null, new IIOImage(image, null, null), iwp);
            iw.dispose();
            fileImageOutputStream.flush();
            fileImageOutputStream.close();
        }
    }

    public static void main(String[] args) {
        path = "F:\\xiehuier";
        destPath = "F:\\temp";
        listFile(new File(path));
    }
}
