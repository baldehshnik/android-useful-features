package com.vd.study.kotlin_code.observer

class TestObservable(value: String) : Observable<String>(value) {

    var observersCount: Int = 0

    override fun register(observer: Observer<String>) {
        super.register(observer)
        observersCount++
    }

    override fun unregister(observer: Observer<String>) {
        super.unregister(observer)
        observersCount--
    }
}