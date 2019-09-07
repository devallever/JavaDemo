package com.allever.demo.designpatterns.bridge;

/**
 * @author allever
 */
public class Message extends AbstractSoft {

    @Override
    void run() {
        System.out.println("运行短信程序");
    }
}
