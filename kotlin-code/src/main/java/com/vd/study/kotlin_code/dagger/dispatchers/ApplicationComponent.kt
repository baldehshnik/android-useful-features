package com.vd.study.kotlin_code.dagger.dispatchers

import dagger.Component
import javax.inject.Singleton

@Component(modules = [DispatchersModule::class])
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
    }
}