package com.vd.study.kotlin_code.dagger

import android.content.Context

val Context.applicationComponent: ApplicationComponent
    get() = when (this) {
        is ApplicationClass -> applicationComponent
        else -> this.applicationContext.applicationComponent
    }