package com.vd.study.java_code.singleton;

public class Singleton {

    private static Singleton singleton = null;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }
}