package com.allever.singleton;

public class DCLSingleton {
    private volatile static DCLSingleton INS = null;

    private DCLSingleton() {}

    public static DCLSingleton getInstance() {
        if (INS == null) {
            synchronized (DCLSingleton.class) {
                if (INS == null) {
                    INS = new DCLSingleton();
                }
            }
        }

        return INS;
    }
}
