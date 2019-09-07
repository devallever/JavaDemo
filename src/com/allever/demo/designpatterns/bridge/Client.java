package com.allever.demo.designpatterns.bridge;

/**
 * @author allever
 */
public class Client {
    public static void main(String[] args) {
        AbstractBaseMobileSystem android = new Android();
        android.setupSoft(new Message());
        android.setupSoft(new Contact());
        android.run();

        AbstractBaseMobileSystem ios = new IOS();
        ios.setupSoft(new Message());
        ios.setupSoft(new Contact());
        ios.run();
    }
}
