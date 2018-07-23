package com.allever.designpatterns.proxy;

/**
 * Created by allever on 18-7-23.
 */
public class ProxyTest {

    public static void main(String[] args){

        MyProxy proxy = new MyProxy(new Chrome());
        proxy.visitGoogle();

    }
}
