package com.vd.study.kotlin_code.observer

open class Observable<T>(value: T) {

    var value: T = value
        set(value) {
            field = value
            notifyObservers()
        }

    private val observers = mutableSetOf<Observer<T>>()

    open fun register(observer: Observer<T>) {
        observers += observer
    }

    open fun unregister(observer: Observer<T>) {
        observers -= observer
    }

    private fun notifyObservers() {
        observers.forEach {
            it.onChanged(value)
        }
    }
}

fun <T> Observable<T>.observe(
    observer: (value: T) -> Unit
): Observer<T> {
    val observerObject = object : Observer<T> {
        override fun onChanged(value: T) {
            observer(value)
        }
    }
    this.register(observerObject)
    return observerObject
}