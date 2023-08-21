package com.vd.study.java_code.observer;

public interface Observer<T> {
    void onChanged(T value);
}
