package cn.goodman.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Shaun on 2017/2/24.
 */
public class SingleClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("192.168.1.7", 8888);
            System.out.println("客户端启动成功！");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            String line = null;
            while((line = br.readLine()) != null) {
                pw.println(line);
                pw.flush();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
