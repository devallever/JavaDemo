package com.allever.designpatterns.observer;

public class Employee implements Observer{
    private String name;
    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(name + ": " + msg);
    }
}
