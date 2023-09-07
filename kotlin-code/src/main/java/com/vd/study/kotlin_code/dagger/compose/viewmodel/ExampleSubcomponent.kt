package com.vd.study.kotlin_code.dagger.compose.viewmodel

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ExampleScope

@Subcomponent(modules = [ExampleModule::class])
@ExampleScope
interface ExampleSubcomponent {

    fun getViewModel(): ExampleViewModel

    @Subcomponent.Builder
    interface Builder {
        fun build(): ExampleSubcomponent
    }
}

@Module
object ExampleModule {

    @Provides
    @ExampleScope
    fun provideExampleViewModel(): ExampleViewModel {
        return ExampleViewModel()
    }
}