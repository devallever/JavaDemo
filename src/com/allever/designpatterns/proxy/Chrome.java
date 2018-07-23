package com.allever.designpatterns.proxy;

/**
 * Created by allever on 18-7-23.
 */
public class Chrome implements Broser {
    @Override
    public void visitGoogle() {
        System.out.println("浏览谷歌");
    }
}
