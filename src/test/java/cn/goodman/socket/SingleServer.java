package cn.goodman.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Shaun on 2017/2/24.
 */
public class SingleServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket= new ServerSocket(8888);
            System.out.println("服务器启动成功");

            socket = serverSocket.accept();
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            while((line = bf.readLine()) != null) {
                System.out.println("服务器接收到输入：" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
