package com.allever.designpatterns.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by allever on 18-7-23.
 */
public class ProxyTest {

    public static void main(String[] args){

        //静态代理
        MyProxy proxy = new MyProxy(new Chrome());
        proxy.visitGoogle();

        //动态代理
        //构造谷歌浏览器
        IBroser chrome = new Chrome();

        //构造动态代理类
        DynamicProxy dynamicProxy = new DynamicProxy(chrome);

        //获取被代理类的Classloader
        ClassLoader classLoader = chrome.getClass().getClassLoader();

        //构造一个代理服务器
        IBroser proxyService = (IBroser) Proxy.newProxyInstance(classLoader, new Class[] {IBroser.class}, dynamicProxy);

        //浏览谷歌
        proxyService.visitGoogle();


    }
}
