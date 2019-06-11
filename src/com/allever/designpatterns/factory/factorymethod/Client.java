package com.allever.designpatterns.factory.factorymethod;

public class Client {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new WatermelonFactory();
//        FruitFactory fruitFactory = new AppleFactory();
        Fruit fruit = fruitFactory.createFruit();
        System.out.println(fruit.getName());
    }
}
