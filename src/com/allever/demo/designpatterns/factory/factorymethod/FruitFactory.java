package com.allever.demo.designpatterns.factory.factorymethod;

public abstract class FruitFactory {
    abstract <T extends Fruit> T createFruit(Class<T> clz);
}
