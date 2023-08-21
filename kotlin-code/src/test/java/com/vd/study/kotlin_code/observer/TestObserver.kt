package com.vd.study.kotlin_code.observer

class TestObserver : Observer<String> {

    var value: String? = null

    override fun onChanged(value: String) {
        this.value = value
    }
}