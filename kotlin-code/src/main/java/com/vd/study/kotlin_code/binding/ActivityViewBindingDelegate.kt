package com.vd.study.kotlin_code.binding

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KProperty

inline fun <reified VB : ViewBinding> AppCompatActivity.viewBinding(
    noinline initializer: (LayoutInflater) -> VB
): ActivityViewBindingDelegate<VB> {
    return ActivityViewBindingDelegate(this, initializer)
}

class ActivityViewBindingDelegate<VB : ViewBinding>(
    private val activity: AppCompatActivity,
    private val initializer: (LayoutInflater) -> VB
): DefaultLifecycleObserver {

    private var binding: VB? = null

    init {
        activity.lifecycle.addObserver(this)
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        if (binding == null) {
            binding = initializer(activity.layoutInflater)
        }

        activity.setContentView(binding!!.root)
        activity.lifecycle.removeObserver(this)
    }

    operator fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): VB {
        var localBinding = binding
        if (localBinding == null) {
            localBinding = initializer(activity.layoutInflater)
            binding = localBinding
        }

        return localBinding
    }
}