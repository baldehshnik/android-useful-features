package com.vd.study.java_code.observer;

public class TestObserver implements Observer<String> {

    String value;

    @Override
    public void onChanged(String value) {
        this.value = value;
    }
}
