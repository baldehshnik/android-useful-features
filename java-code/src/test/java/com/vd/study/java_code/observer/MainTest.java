package com.vd.study.java_code.observer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {

    @Test
    public void observersCount_AfterObserverAdding_ObservableContainsOneObserver() {
        TestObservable observable = new TestObservable("");
        TestObserver observer = new TestObserver();

        observable.register(observer);

        assertEquals(1, observable.observersCount);
    }

    @Test
    public void observersCount_AfterObserversAdding_ObservableContainsThreeObservers() {
        TestObservable observable = new TestObservable("");
        TestObserver observer1 = new TestObserver();
        TestObserver observer2 = new TestObserver();
        TestObserver observer3 = new TestObserver();

        observable.register(observer1);
        observable.register(observer2);
        observable.register(observer3);

        assertEquals(3, observable.observersCount);
    }

    @Test
    public void observersCount_AfterObserversAddingAndRemoving_ObservableContainsZeroObservers() {
        TestObservable observable = new TestObservable("");
        TestObserver observer1 = new TestObserver();
        TestObserver observer2 = new TestObserver();

        observable.register(observer1);
        observable.register(observer2);
        observable.unregister(observer1);
        observable.unregister(observer2);

        assertEquals(0, observable.observersCount);
    }

    @Test
    public void observableValue_AfterObservableValueChanging_ObservableContainsNewObservableValue() {
        TestObservable observable = new TestObservable("");

        observable.setValue("TEST");

        assertEquals(observable.getValue(), "TEST");
    }

    @Test
    public void observableValue_AfterObservableValueChanging_ObservableContainsLastAddedObservableValue() {
        TestObservable observable = new TestObservable("");

        observable.setValue("TEST1");
        observable.setValue("TEST2");
        observable.setValue("TEST3");

        assertEquals("TEST3", observable.getValue());
    }

    @Test
    public void observableValue_AfterObservableValueChanging_AllObserversReceivedNewValue() {
        TestObservable observable = new TestObservable("");
        TestObserver observer1 = new TestObserver();
        TestObserver observer2 = new TestObserver();
        TestObserver observer3 = new TestObserver();

        observable.register(observer1);
        observable.register(observer2);
        observable.register(observer3);
        observable.setValue("TEST");

        assertEquals("TEST", observer1.value);
        assertEquals("TEST", observer2.value);
        assertEquals("TEST", observer3.value);
    }
}
