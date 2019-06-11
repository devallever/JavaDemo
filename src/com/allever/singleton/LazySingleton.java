package com.allever.singleton;

public class LazySingleton {
    private static LazySingleton INS = null;
    private LazySingleton() {}

    public synchronized static LazySingleton getInstance() {
        if (INS == null) {
            INS = new LazySingleton();
        }

        return INS;
    }
}
