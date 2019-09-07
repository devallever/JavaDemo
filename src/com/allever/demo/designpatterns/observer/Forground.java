package com.allever.demo.designpatterns.observer;

import java.util.LinkedList;
import java.util.List;

public class Forground implements Subject {
    private List<Observer> observerList = new LinkedList<>();
    private String mMsg = "";

    public void regist(Observer observer) {
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    public void unRegist(Observer observer) {
        observerList.remove(observer);
    }

    public void setMessage(String msg) {
        mMsg = msg;
    }

    @Override
    public void notifyDataSetChanged() {
        for (Observer observer: observerList) {
            observer.update(mMsg);
        }
    }
}
