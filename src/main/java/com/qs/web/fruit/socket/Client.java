package com.qs.web.fruit.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author shuaion 2018/1/24
 **/
public class Client {

    public static void main(String[] args) {

       /* try {
            Socket s = new Socket("127.0.0.1",8888);

            //构建IO
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            //向服务器端发送一条消息
            bw.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
            bw.flush();

            //读取服务器返回的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String mess = br.readLine();
            System.out.println("服务器："+mess);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            Socket socket = new Socket("127.0.0.1", 7777);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
            writer.write("hello i am socket client!\n");//向服务端发送数据
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String message = reader.readLine();
            System.out.println("接收得服务端响应数据:"+message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
