package com.vd.study.java_code.singleton;

public class TestThreadSingleton {

    private Singleton singleton = null;

    public Boolean isError = false;

    public synchronized void checkSingleton(Singleton singleton) {
        if (this.singleton == null) {
            this.singleton = singleton;
            return;
        }
        isError = !(this.singleton == singleton);
    }
}