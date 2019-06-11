package com.allever.designpatterns.factory.factorymethod;

public class AppleFactory extends FruitFactory {
    @Override
    Fruit createFruit() {
       return new Apple();
    }
}
