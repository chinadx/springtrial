package cn.goodman.io;

import java.io.*;

/**
 * 将单列的文件转置成行列形式
 * Created by Shaun on 2017/3/21.
 */
public class FileExtract {
    public static void extract(String srcFile, String destFile) throws IOException {
        InputStream fi = new FileInputStream(srcFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fi));
        String line = null;
        while((line = br.readLine()) != null) {
            if(line.equals("")) {
                System.out.println("");
            } else {
                System.out.print(line + "\t");
            }
        }
    }

    public static void main(String[] args) {
        String inFile = "C:\\Users\\Shaun\\Desktop\\五星酒店.txt";
        try {
            extract(inFile, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
