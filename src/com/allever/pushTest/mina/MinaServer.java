package com.allever.pushTest.mina;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.net.InetSocketAddress;

/**
 * Created by allever on 18-8-2.
 */
public class MinaServer {
    public static void main(String[] args){
        try {
            //1.创建Acceptor
            NioSocketAcceptor acceptor = new NioSocketAcceptor();
            //2.handler回话管理和消息处里
            acceptor.setHandler(new MyServerHandler());
            //3.拦截器:数据转换 object -> byte ->object
            //factory 数据加解码
            acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MyTextLineCodecFactory()));

            //设置
            // READER_IDLE:多久没读到客户端的消息, 则进入空闲状态:
            //检测客户端是否掉线
            acceptor.getSessionConfig().setIdleTime(IdleStatus.READER_IDLE,5);
            acceptor.getSessionConfig().setReaderIdleTime(5);
            //4.bind
            acceptor.bind(new InetSocketAddress(8989));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
