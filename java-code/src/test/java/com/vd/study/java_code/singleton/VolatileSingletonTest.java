package com.vd.study.java_code.singleton;

import org.junit.Assert;
import org.junit.Test;

public class VolatileSingletonTest {

    @Test
    public void volatileSingletonCreation_AfterSingleInvoke_VolatileSingletonWasCreated() {
        VolatileSingleton singleton = VolatileSingleton.getInstance();

        Assert.assertNotNull(singleton);
    }

    @Test
    public void volatileSingletonCreation_AfterTwoInvokes_ContainsTheSameObjects() {
        VolatileSingleton singleton1 = VolatileSingleton.getInstance();
        VolatileSingleton singleton2 = VolatileSingleton.getInstance();

        Assert.assertSame(singleton1, singleton2);
    }

    @Test
    public void volatileSingletonCreation_AfterTwoInvokesInOtherThreads_ContainsTheSameObjects() {
        TestThreadVolatileSingleton testThreadVolatileSingleton = new TestThreadVolatileSingleton();
        Thread thread1 = new Thread(() -> testThreadVolatileSingleton.checkSingleton(VolatileSingleton.getInstance()));
        Thread thread2 = new Thread(() -> testThreadVolatileSingleton.checkSingleton(VolatileSingleton.getInstance()));

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertFalse(testThreadVolatileSingleton.isError);
    }
}