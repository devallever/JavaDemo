package com.allever.demo.designpatterns.factory.factorymethod;

public class Client {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new ConcreteFactory();
//        FruitFactory fruitFactory = new AppleFactory();
        Fruit fruit = fruitFactory.createFruit(Apple.class);
        System.out.println(fruit.getName());
    }
}
