package com.allever.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by allever on 18-7-23.
 */
public class ChatClient {
    public static void main(String[] args) throws IOException{

        Socket socket = new Socket("192.168.43.235", 8888);
        socket.getInputStream();
        socket.close();


    }
}
