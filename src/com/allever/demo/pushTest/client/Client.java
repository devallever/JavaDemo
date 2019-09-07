package com.allever.demo.pushTest.client;

import com.allever.demo.pushTest.CloseUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by allever on 18-8-1.
 */
public class Client {
    public static void main(String[] args){
        Client client = new Client();
        client.startClient();
    }

    private void startClient() {
        Socket socket = null;
        BufferedReader readerFromKeyboard = null;
        BufferedReader readerFromServer = null;
        BufferedWriter writer = null;
        try {
            socket = new Socket("127.0.0.1", 8989);
            readerFromKeyboard = new BufferedReader(new InputStreamReader(System.in));
            readerFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            startServerListener(readerFromServer);

            String keyBoardContent = null;
            int count = 0;
            while (!(keyBoardContent = readerFromKeyboard.readLine()).equalsIgnoreCase("bye")){
                writer.write(keyBoardContent);
                if (count % 2 == 0){
                    writer.write( "\n");
                }
                count ++;
                writer.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            CloseUtil.close(readerFromServer);
            CloseUtil.close(writer);
            CloseUtil.close(readerFromKeyboard);
            CloseUtil.close(socket);
        }
    }

    public void startServerListener(final BufferedReader reader){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String response = null;
                    while ((response = reader.readLine()) != null){
                        System.out.println(response);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    CloseUtil.close(reader);
                }

            }
        }).start();
    }


}
