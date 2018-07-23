package com.allever.designpatterns.proxy;

/**
 * Created by allever on 18-7-23.
 */
public class MyProxy implements Broser {
    private Broser mBroser;

    public MyProxy(Broser concrectObj){
        mBroser = concrectObj;
    }
    @Override
    public void visitGoogle() {
        mBroser.visitGoogle();
    }
}
