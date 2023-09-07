package com.vd.study.kotlin_code.dagger.compose.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
inline fun <reified T : BaseViewModel> daggerViewModel(
    key: String? = null,
    crossinline viewModelCreator: () -> T
): T {
    return viewModel(
        modelClass = T::class.java,
        key = key,
        factory = object : ViewModelProvider.Factory {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return viewModelCreator() as T
            }
        }
    )
}