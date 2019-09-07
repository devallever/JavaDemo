package com.allever.demo.annotation.practice;

/**
 * Created by allever on 18-7-4.
 */
public class NoBug {

    @ButTest
    public void add(){
        System.out.println("1 + 1 = "  + 1 + 1);
    }

    @ButTest
    public void chengfa(){
        System.out.println("3 * 5 = " + 3 * 5);
    }

    @ButTest
    public void chufa(){
        System.out.println("6 / 0 = " + 6 / 0);
    }


}
