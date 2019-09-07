package com.allever.demo.singleton;

public class StaticSingleton {
    private static class Holder {
        private static StaticSingleton INS = new StaticSingleton();
    }

    private StaticSingleton() {}

    public static StaticSingleton getInstance() {
        return Holder.INS;
    }
}
