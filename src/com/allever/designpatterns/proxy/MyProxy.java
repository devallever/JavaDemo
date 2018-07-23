package com.allever.designpatterns.proxy;

/**
 * Created by allever on 18-7-23.
 */
public class MyProxy implements IBroser {
    private IBroser mIBroser;

    public MyProxy(IBroser concrectObj){
        mIBroser = concrectObj;
    }
    @Override
    public void visitGoogle() {
        mIBroser.visitGoogle();
    }
}
