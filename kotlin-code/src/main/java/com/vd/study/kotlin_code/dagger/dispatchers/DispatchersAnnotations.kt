package com.vd.study.kotlin_code.dagger.dispatchers

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MainDispatcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class IODispatcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DefaultDispatcher