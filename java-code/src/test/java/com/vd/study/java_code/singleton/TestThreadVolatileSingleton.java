package com.vd.study.java_code.singleton;

public class TestThreadVolatileSingleton {

    private VolatileSingleton singleton = null;

    public volatile Boolean isError = false;

    public void checkSingleton(VolatileSingleton singleton) {
        if (this.singleton == null) {
            synchronized (TestThreadVolatileSingleton.class) {
                this.singleton = singleton;
                return;
            }
        }
        isError = !(this.singleton == singleton);
    }
}