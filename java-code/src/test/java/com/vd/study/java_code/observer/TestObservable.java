package com.vd.study.java_code.observer;

public class TestObservable extends Observable<String> {

    public TestObservable(String value) {
        super(value);
    }

    int observersCount = 0;

    @Override
    public void register(Observer<String> observer) {
        super.register(observer);
        observersCount++;
    }

    @Override
    public void unregister(Observer<String> observer) {
        super.unregister(observer);
        observersCount--;
    }
}
