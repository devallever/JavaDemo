package com.allever.demo.designpatterns.factory.simplefactory;

public class Client {
    public static void main(String[] args) {
        Apple apple = Factory.createFruit();
        int appleColor = apple.getColor();
    }
}
