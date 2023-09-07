package com.vd.study.kotlin_code.dagger.compose.viewmodel

import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {

    fun exampleSubcomponentBuilder(): ExampleSubcomponent.Builder

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
    }
}

@Module(subcomponents = [ExampleSubcomponent::class])
object ApplicationModule