package com.vd.study.kotlin_code.dagger

import android.app.Application

class ApplicationClass : Application() {

    private var _applicationComponent: ApplicationComponent? = null
    val applicationComponent: ApplicationComponent
        get() = _applicationComponent ?: throw IllegalArgumentException(
            "Application Component was not implemented"
        )

    override fun onCreate() {
        super.onCreate()
        _applicationComponent = DaggerApplicationComponent.builder()
            .build()
    }
}