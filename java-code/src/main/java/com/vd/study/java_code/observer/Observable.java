package com.vd.study.java_code.observer;

import java.util.HashSet;
import java.util.Set;

public class Observable<T> {

    private T value;

    private final Set<Observer<T>> observers = new HashSet<>();

    public Observable(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
        notifyObservers();
    }

    public T getValue() {
        return value;
    }

    public void register(Observer<T> observer) {
        observers.add(observer);
    }

    public void unregister(Observer<T> observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer<T> observer : observers) {
            observer.onChanged(value);
        }
    }
}
