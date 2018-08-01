package com.allever.pushTest.server;

import com.allever.pushTest.CloseUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by allever on 18-8-1.
 */
public class SocketServer {

    BufferedWriter writer;

    public static void main(String[] args){

        SocketServer socketServer = new SocketServer();
        socketServer.startServer();

    }

    private void startServer() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader reader = null;
        try {
            serverSocket = new ServerSocket(8989);
            System.out.println("server started...");
            socket = serverSocket.accept();
            System.out.println("client " + socket.hashCode() + " connected.");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        writer.write("server beat once...\n");
                        writer.flush();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }, 3000, 3000);

            String clientMsg = null;
            while (! (clientMsg = reader.readLine()).equalsIgnoreCase("bye")){
                System.out.println("clientMsg = " + clientMsg);
                writer.write("server reply: " + clientMsg + "\n");
                writer.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            CloseUtil.close(writer);
            CloseUtil.close(reader);
            CloseUtil.close(socket);
            CloseUtil.close(serverSocket);
        }
    }


}
