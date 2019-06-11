package com.allever.pushTest.mina;

import javafx.application.ConditionalFeature;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

/**
 * Created by allever on 18-8-2.
 */
public class MinaClient {
    public static void main(String[] args)throws Exception{
        NioSocketConnector connector = new NioSocketConnector();
        connector.setHandler(new MyClientHandler());
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
        ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", 8989));
        future.awaitUninterruptibly();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String content;
        while (!(content = reader.readLine()).equalsIgnoreCase("bye")){
            future.getSession().write(content + "\n");
        }
    }
}
