package com.allever.demo.pushTest.server;

import com.allever.demo.pushTest.CloseUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by allever on 18-8-1.
 */
public class SocketServer {

    BufferedWriter writer;

    BufferedReader reader;

    public static void main(String[] args){

        SocketServer socketServer = new SocketServer();
        socketServer.startServer();

    }

    private void startServer() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(9898);
            System.out.println("server started...");
            while (true){
                socket = serverSocket.accept();
                managConnection(socket);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            CloseUtil.close(serverSocket);
        }
    }

    public void managConnection(final Socket socket){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("client " + socket.hashCode() + " connected.");
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    String clientMsg = null;
                    while ((clientMsg = reader.readLine()) != null){
                        System.out.println("client " + socket.hashCode() + " clientMsg = " + clientMsg);
                        writer.write("server reply: " + clientMsg + "\n");
                        writer.flush();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    CloseUtil.close(writer);
                    CloseUtil.close(reader);
                    CloseUtil.close(socket);
                }
            }
        }).start();
    }

}
