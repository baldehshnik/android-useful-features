package com.vd.study.java_code.singleton;

import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {

    @Test
    public void singletonCreation_AfterSingleInvoke_SingletonWasCreated() {
        Singleton singleton = Singleton.getInstance();

        Assert.assertNotNull(singleton);
    }

    @Test
    public void singletonCreation_AfterTwoInvokes_ContainsTheSameObjects() {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        Assert.assertSame(singleton1, singleton2);
    }

    @Test
    public void singletonCreation_AfterTwoInvokesInOtherThreads_ContainsTheSameObjects() {
        TestThreadSingleton testThreadSingleton = new TestThreadSingleton();
        Thread thread1 = new Thread(() -> testThreadSingleton.checkSingleton(Singleton.getInstance()));
        Thread thread2 = new Thread(() -> testThreadSingleton.checkSingleton(Singleton.getInstance()));

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertFalse(testThreadSingleton.isError);
    }
}