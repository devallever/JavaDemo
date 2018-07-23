package com.allever.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by allever on 18-7-23.
 */
public class DynamicProxy implements InvocationHandler {
    private Object mObj;

    public DynamicProxy(Object object){
        mObj = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(mObj, args);
        return result;
    }
}
