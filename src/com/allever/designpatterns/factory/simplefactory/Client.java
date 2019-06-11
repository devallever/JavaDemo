package com.allever.designpatterns.factory.simplefactory;

public class Client {
    public static void main(String[] args) {
        Apple apple = Factory.createFruit();
        int appleColor = apple.getColor();
    }
}
