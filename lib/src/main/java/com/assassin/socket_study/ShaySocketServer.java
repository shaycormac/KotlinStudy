package com.assassin.socket_study;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/17 14:24
 * Version:     1.0
 * Description: 如下的GreetingServer 程序是一个服务器端应用程序，使用 Socket 来监听一个指定的端口。
 * 
 * 编译以上两个 java 文件代码，并执行以下命令来启动服务，使用端口号为 6066：
 * 
 * $ javac GreetingServer.java 
 * $ java GreetingServer 6066
 * 
 * 
 * 等待远程连接，端口号为：6066...
 * 
 */
public class ShaySocketServer extends Thread {

    private ServerSocket mServerSocket;

    // 初始化
    public ShaySocketServer(int port) throws IOException {

        mServerSocket = new ServerSocket(port);
        // 设置超时时间
        mServerSocket.setSoTimeout(10000);
    }

    @Override
    public void run() {
        while (true) {

            try {
                System.out.println("等待远程连接，端口号为：" + mServerSocket.getLocalPort() + "...");
                // 这边就会堵塞，等待，超时10秒的会，就会推出
                Socket server = mServerSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println("从客户端读取到的数据：" + in.readUTF());

                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");

                server.close();


            } catch (Exception e) {
                e.printStackTrace();
                break;
            }


        }
    }


    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            Thread t = new ShaySocketServer(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
