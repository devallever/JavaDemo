package com.allever.designpatterns.factory.factorymethod;

public class WatermelonFactory extends FruitFactory {
    @Override
    Fruit createFruit() {
        return new Watermelon();
    }
}
