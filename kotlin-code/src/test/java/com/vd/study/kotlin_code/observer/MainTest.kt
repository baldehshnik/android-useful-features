package com.vd.study.kotlin_code.observer

import org.junit.Test
import org.junit.Assert.assertEquals

class MainTest {

    @Test
    fun observersCountExtensionFunction_AfterObserverAdding_ObservableContainsOneObserver() {
        val observable = TestObservable("")

        observable.observe { }

        assertEquals(1, observable.observersCount)
    }

    @Test
    fun observersCountExtensionFunction_AfterObserversAdding_ObservableContainsThreeObservers() {
        val observable = TestObservable("")

        observable.observe { }
        observable.observe { }
        observable.observe { }

        assertEquals(3, observable.observersCount)
    }

    @Test
    fun observersCountExtensionFunction_AfterObserverAdding_ObservableContainsZeroObservers() {
        val observable = TestObservable("")
        val observer = observable.observe { }

        observable.unregister(observer)

        assertEquals(0, observable.observersCount)
    }

    @Test
    fun observableValueExtensionFunction_AfterObserverAdding_ObserverContainsNewObservableValue() {
        val observable = TestObservable("")
        var result: String? = null

        observable.observe {
            result = it
        }
        observable.value = "TEST"

        assertEquals("TEST", result)
    }

    @Test
    fun observersCount_AfterObserverAdding_ObservableContainsOneObserver() {
        val observable = TestObservable("")
        val observer = TestObserver()

        observable.register(observer)

        assertEquals(1, observable.observersCount)
    }

    @Test
    fun observersCount_AfterObserversAdding_ObservableContainsThreeObservers() {
        val observable = TestObservable("")
        val observer1 = TestObserver()
        val observer2 = TestObserver()
        val observer3 = TestObserver()

        observable.register(observer1)
        observable.register(observer2)
        observable.register(observer3)

        assertEquals(3, observable.observersCount)
    }

    @Test
    fun observersCount_AfterObserversAddingAndRemoving_ObservableContainsZeroObservers() {
        val observable = TestObservable("")
        val observer1 = TestObserver()
        val observer2 = TestObserver()

        observable.register(observer1)
        observable.register(observer2)
        observable.unregister(observer1)
        observable.unregister(observer2)

        assertEquals(0, observable.observersCount)
    }

    @Test
    fun observableValue_AfterObservableValueChanging_ObservableContainsNewObservableValue() {
        val observable = TestObservable("")

        observable.value = "TEST"

        assertEquals(observable.value, "TEST")
    }

    @Test
    fun observableValue_AfterObservableValueChanging_ObservableContainsLastAddedObservableValue() {
        val observable = TestObservable("")

        observable.value = "TEST1"
        observable.value = "TEST2"
        observable.value = "TEST3"

        assertEquals("TEST3", observable.value)
    }

    @Test
    fun observableValue_AfterObservableValueChanging_AllObserversReceivedNewValue() {
        val observable = TestObservable("")
        val observer1 = TestObserver()
        val observer2 = TestObserver()
        val observer3 = TestObserver()

        observable.register(observer1)
        observable.register(observer2)
        observable.register(observer3)
        observable.value = "TEST"

        assertEquals("TEST", observer1.value)
        assertEquals("TEST", observer2.value)
        assertEquals("TEST", observer3.value)
    }
}