package com.allever.demo.designpatterns.factory.factorymethod;

public class ConcreteFactory extends FruitFactory {


    @Override
    public <T extends Fruit> T createFruit(Class<T> clz) {
        Fruit fruit = null;
        try {
            fruit =  (Fruit)(Class.forName(clz.getName()).getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T)fruit;
    }

    @Override
    Fruit createFruit() {
        return null;
    }
}
