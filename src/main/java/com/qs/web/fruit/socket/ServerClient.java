package com.qs.web.fruit.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shuaion 2018/1/24
 **/
public class ServerClient {

    public static void main(String[] args) {

        /*try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("启动服务器....");
            Socket s = ss.accept();
            System.out.println("客户端:"+s.getInetAddress().getLocalHost()+"已连接到服务器");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //读取客户端发送来的消息
            String mess = br.readLine();
            System.out.println("客户端："+mess);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write(mess+"\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            Socket socket = serverSocket.accept();//服务端接收客户端请求
            System.out.println("======here=======");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();
            System.out.println("收到客户端信息:"+message);


            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("服务端响应信息:"+message+"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
