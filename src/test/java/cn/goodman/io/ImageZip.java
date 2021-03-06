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
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shaun on 2017/2/13.
 * 将指定目录的图片按比例压缩
 */
public class ImageZip implements Runnable{
    private static final int FIXED_MAX_WIDTH = 1024;
    private static final int FIXED_MAX_HEIGHT = 768;
    private static final int IMAGE_QUALITY_PERCENT = 50;
    private int index;
    private int threadNum;
    /**
     * srcPath是图片的原路径
     * destpath是压缩之后的目标路径
     */
    private String srcPath = null;
    private String destPath = null;
    private File rootFileForThread = null;

    public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    public ImageZip(int index, int threadNum, String srcPath, String destPath, File file) {
        this.index = index;
        this.threadNum = threadNum;
        this.srcPath = srcPath;
        this.destPath = destPath;
        this.rootFileForThread = file;
    }

    @Override
    public void run() {
        if(rootFileForThread != null) {
            listFile(rootFileForThread);
        }
    }

    public void listFile(File file) {
        if (file != null) {
            if (file.isDirectory()) {
//                System.out.println("[" + this.index + "]" + "这是个目录，" + file.getName());
                /**
                 * 根据目录名判断是否归属本线程处理
                 * 只判断目录名为1000的整数倍的
                 * 按照目录名除以1000，再使用线程数进行取模操作
                 * 之所以这么设计，是因为这是图片目录结构决定的。1000整数倍为第一级目录，下面是第二级目录。
                 * 我们只对第一级目录进行分线程处理
                 */
                String rr = file.getName();
                if(isNumeric(rr)) {
                    int rootPath = Integer.parseInt(rr);
//                    System.out.println(rootPath);
                    if (rootPath % 1000 == 0) {
//                        System.out.println("[" + this.index + "]" + "aaaaa");
                        if ((rootPath/1000) % this.threadNum != this.index) {
//                            System.out.println("[" + this.index + "]" + "bbbb");
                            return;
                        }
                    }
                }
                System.out.println("[" + this.index + "]" + file.getPath());
                File[] files = file.listFiles();
                for (File f : files) {
                    listFile(f);
                }
            } else {
//                System.out.print("[" + this.index + "]" + "这是个文件，" + file.getName() + "，" + file.getPath() + "，大小为：" + file.length());
                BufferedImage bufferedImage = null;
                File f = null;
                File ff = null;
                try {
                    /**
                     * 读取图片文件
                     */
                    bufferedImage = ImageIO.read(file);
//                    int width = bufferedImage.getWidth(null);
//                    int height = bufferedImage.getHeight(null);
//                    System.out.println("，分辨率为：" + width + "x" + height);

                    /**
                     * filepath为带路径的文件名
                     * fileDir为文件路径
                     */
//                    String filepath = file.getPath();
                    String fileDir = file.getParent();

                    /**
                     * 获取目标目录并创建目录
                     */
                    StringBuffer newPath = new StringBuffer();
                    newPath.append(destPath);
                    newPath.append(fileDir.substring(srcPath.length()));
                    f = new File(newPath.toString());
                    f.mkdirs();

                    /**
                     * 继续拼装目标文件全名
                     */
                    newPath.append(File.separatorChar);
                    newPath.append(file.getName());
                    ff = new File(newPath.toString());
                    if(ff.exists()) {
                        /**
                         * 如果目标已经存在了，就不需要费劲了。
                         */
                        return;
                    }
                    /**
                     * 调用压缩处理方法
                     */
                    zipJPEG(ff, bufferedImage, IMAGE_QUALITY_PERCENT, null);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    bufferedImage = null;
                    ff = null;
                    f = null;
                }
            }
        }
    }

    /**
     * 按质量比例压缩JPEG 文件
     * @param file 保存的目标文件
     * @param image 保存的源图像
     * @param quality 保存的 JPEG 图像质量百分比
     * @param listener 保存进度监听器
     */
    public static void zipJPEG(File file, BufferedImage image, int quality, IIOWriteProgressListener listener) throws IOException {
        Iterator it = ImageIO.getImageWritersBySuffix("jpg");
        if (it.hasNext()) {
            FileImageOutputStream fileImageOutputStream = new FileImageOutputStream(file);
            ImageWriter iw = (ImageWriter) it.next();
            ImageWriteParam iwp = iw.getDefaultWriteParam();
            iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            iwp.setCompressionQuality((float) quality / 100f);
            iw.setOutput(fileImageOutputStream);
            iw.addIIOWriteProgressListener(listener);

            /**
             * 如果原始图片尺寸大于1024，先压缩到1024
             */
            int w = image.getWidth();
            int h = image.getHeight();
            if (w > FIXED_MAX_WIDTH || h > FIXED_MAX_HEIGHT) {
                int w_new = FIXED_MAX_WIDTH;
                int h_new = (h * FIXED_MAX_WIDTH) / w;
                if(h_new > FIXED_MAX_HEIGHT) {
                    h_new = FIXED_MAX_HEIGHT;
                    w_new = (w * FIXED_MAX_HEIGHT) / h;
                }
                BufferedImage zip = new BufferedImage(w_new, h_new, BufferedImage.TYPE_INT_RGB);

                zip.getGraphics().drawImage(
                        image.getScaledInstance(w_new, h_new, Image.SCALE_DEFAULT), 0, 0, null);
                iw.write(null, new IIOImage(zip, null, null), iwp);
                zip = null;
            } else {
                iw.write(null, new IIOImage(image, null, null), iwp);
            }
            iw.dispose();

            fileImageOutputStream.flush();
            fileImageOutputStream.close();
        }
    }

    public static void main(String[] args) {
        String srcPath = "F:\\xiehuier";
        String destPath = "F:\\temp\\zip";
//        String srcPath = "/mnt/usb/xiehuier/hotelimg";
//        String destPath = "/usr/local/xhimg";
//        listFile(new File(srcPath));

        ExecutorService service = Executors.newCachedThreadPool();
//        ExecutorService service = new ThreadPoolExecutor(8, 10, 60, TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>());
        int threadNum = 16;
        for(int i=0; i<threadNum; i++) {
            service.execute(new ImageZip(i, threadNum, srcPath, destPath, new File(srcPath)));
        }
//        System.out.println("submit finish");
        service.shutdown();
    }

}
