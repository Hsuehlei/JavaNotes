package socket;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/21 16:41
 */
public class SocketDemo {

    @Test
    public void client() {
        Socket socket = null;
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;

        try {

            socket = new Socket("127.0.0.1",8803);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //客户端收到消息
            System.out.println(bufferedReader.readLine());

            //客户端发消息给服务端
            bufferedWriter.write("Shabi");
            bufferedWriter.newLine();
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
    }

    @Test
    public void server() {
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8803);
            while (true) {
                socket = serverSocket.accept();
                System.out.println("> 服务器已经启动");
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                //服务端发送信息给客户端
                bufferedWriter.write("I am Server");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                //服务端接收客户端的消息
                System.out.println(bufferedReader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
}
