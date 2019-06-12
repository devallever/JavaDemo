package com.allever.designpatterns.stragety;

public class BusCalculator implements Calculator {
    @Override
    public int calculate(int km) {
        return 5 * km;
    }
}
