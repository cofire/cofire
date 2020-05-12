package com.cofire.designPattern.Singleton;


public class DCLSingleton {
    private volatile static DCLSingleton DCLSingleton;

    private DCLSingleton() {
    }

    public static DCLSingleton getSingleton() {
        if (DCLSingleton == null) {
            synchronized (DCLSingleton.class) {
                if (DCLSingleton == null) {
                    DCLSingleton = new DCLSingleton();
                }
            }
        }
        return DCLSingleton;
    }
}
