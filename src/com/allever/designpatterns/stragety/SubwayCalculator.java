package com.allever.designpatterns.stragety;

public class SubwayCalculator implements Calculator {
    @Override
    public int calculate(int km) {
        return 7 * km;
    }
}
