package com.vd.study.kotlin_code.observer

interface Observer<in T> {
    fun onChanged(value: T)
}