package com.allever.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by allever on 18-7-23.
 */
public class ChatClient {
    public static void main(String[] args) throws IOException{

        Socket socket = new Socket("192.168.43.235", 8888);
        BufferedReader readerFromKeyboard = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFromKeyServer = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
        String content;
        while (!(content = readerFromKeyboard.readLine()).equalsIgnoreCase("bye")){
            writer.write(content + "\n");
            writer.flush();

            String response = readerFromKeyServer.readLine();
            System.out.println(response);
        }


    }
}
