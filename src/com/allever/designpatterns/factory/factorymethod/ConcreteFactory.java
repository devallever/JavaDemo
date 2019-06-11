package com.allever.designpatterns.factory.factorymethod;

public class ConcreteFactory extends FruitFactory {


    @Override
    public <T extends Fruit> T createFruit(Class<T> clz) {
        Fruit fruit = null;
        try {
            fruit =  (Fruit)(Class.forName(clz.getName()).newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T)fruit;
    }
}
