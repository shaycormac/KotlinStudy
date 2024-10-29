package com.assassin.socket_study;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/17 14:13
 * Version:     1.0
 * Description: 如下的ShaySocketClient是一个客户端程序，该程序通过 socket 连接到服务器并发送一个请求，然后等待一个响应。
 * 
 * 
 * 新开一个命令窗口，执行以上命令来开启客户端：
 * $ javac GreetingClient.java 
 * $ java GreetingClient localhost 6066
 * 
 * 
 * 连接到主机：localhost ，端口号：6066
 * 远程主机地址：localhost/127.0.0.1:6066
 * 服务器响应： 谢谢连接我：/127.0.0.1:6066
 * Goodbye!
 * 
 */
public class ShaySocketClient {
    public static void main(String[] args) {

        // 通过main函数的值传过来,拿到服务器的名字和端口
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);

        try {
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            // 拿到自己的写流
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            //写给服务端
            out.writeUTF("Hello from " + client.getLocalSocketAddress());

            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            // 从服务端读取数据
            System.out.println("服务器响应： " + in.readUTF());
            // 然后结束连接
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
