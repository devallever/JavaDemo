package com.allever.demo.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class Coder implements Observer {
    private String mName = "";
    public Coder(String name) {
        mName = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        String msg = (String) arg;
        System.out.println(mName + ": " + msg);
    }
}
