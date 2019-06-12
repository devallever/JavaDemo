package com.allever.designpatterns.observer;

import java.util.Observable;

public class DevTech extends Observable {
    public void postMsg(String msg) {
        setChanged();
        notifyObservers(msg);
    }
}
