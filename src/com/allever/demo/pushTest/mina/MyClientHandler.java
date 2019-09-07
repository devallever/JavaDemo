package com.allever.demo.pushTest.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * Created by allever on 18-8-2.
 */
public class MyClientHandler extends IoHandlerAdapter {

    //客户端与服务器回话创建时
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("sessionCreated");
    }
    //客户端与服务器回话打开时
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("sessionOpened");
    }

    //客户端与服务器回话关闭时
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("sessionClosed");
    }

    //回话进入到空闲状态
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("sessionIdle");
    }

    //网络链接出现异常
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        System.out.println("exceptionCaught");
    }

    //收到消息
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String content = null;
        content = (String)message;
        if (content != null){
            System.out.println(content);
        }

    }

    //发出了消息
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("messageSent");
    }

}
