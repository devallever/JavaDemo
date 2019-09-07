package com.allever.demo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by allever on 18-7-23.
 */
public class MyChatRoomServer {

    //缓存客户端Socket
    private static List<Socket> sClientSocketList = new LinkedList<>();

    public static void main(String[] args) throws IOException{

        ServerSocket serverSocket = new ServerSocket(8888);

        while (true){

            Socket socket = serverSocket.accept();

            sClientSocketList.add(socket);

            //开启线程执行
            new Thread(new ServerThread(socket)).start();

        }

    }


    public static class ServerThread implements Runnable{

        //当前线程处理的Socket
        private Socket mSocket;

        //Socket对应输入流
        private BufferedReader mBufferedReader;

        public ServerThread(Socket socket) throws IOException{

            mSocket = socket;

            //获取输入流
            mBufferedReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "UTF-8"));

            System.out.println("client:" + socket.getInetAddress() + " 已连接");

        }

        @Override
        public void run() {

            try {
                String content = null;

                //利用循环不断向客户端Client发送消息
                while ((content = readFromClient()) != null){

                    for (Iterator<Socket> iterator = sClientSocketList.iterator(); iterator.hasNext(); ){
                        Socket socket = iterator.next();
                        try {
                            OutputStream outputStream = socket.getOutputStream();
                            outputStream.write((content + "\n").getBytes("UTF-8"));
                            System.out.println("Server -> client: " + socket.getInetAddress() + "");
                        }catch (SocketException e){
                            e.printStackTrace();

                            iterator.remove();
                            System.out.println(sClientSocketList);

                        }finally {

                        }
                    }

                }


            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }


        }


        private String readFromClient(){
            try {
                return mBufferedReader.readLine();
            }catch (Exception e){
                e.printStackTrace();

                sClientSocketList.remove(mSocket);
            }
            return null;
        }

    }


}
