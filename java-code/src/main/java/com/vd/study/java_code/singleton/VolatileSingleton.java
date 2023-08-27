package com.vd.study.java_code.singleton;

public class VolatileSingleton {

    private static volatile VolatileSingleton singleton = null;

    private VolatileSingleton() {}

    public static VolatileSingleton getInstance() {
        VolatileSingleton local = singleton;
        if (local == null) {
            synchronized (Singleton.class) {
                local = singleton;
                if (local == null) {
                    local = new VolatileSingleton();
                    singleton = local;
                }
            }
        }

        return local;
    }
}