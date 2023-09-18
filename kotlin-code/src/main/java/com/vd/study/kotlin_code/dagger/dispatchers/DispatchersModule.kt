package com.vd.study.kotlin_code.dagger.dispatchers

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
object DispatchersModule {

    @Provides
    @MainDispatcher
    fun provideMainDispatcher(): MainCoroutineDispatcher {
        return Dispatchers.Main
    }

    @Provides
    @IODispatcher
    fun provideIODispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }
}