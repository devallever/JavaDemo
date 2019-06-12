package com.allever.designpatterns.stragety;

public class TraficCalculator {
    private Calculator mCalculator;
    public static void main(String[] args) {
        TraficCalculator calculator = new TraficCalculator();
        calculator.setStragety(new SubwayCalculator());
        calculator.calculate(5);

    }

    public void setStragety(Calculator calculator) {
        mCalculator = calculator;
    }

    public int calculate(int km) {
        return mCalculator.calculate(km);
    }
}
