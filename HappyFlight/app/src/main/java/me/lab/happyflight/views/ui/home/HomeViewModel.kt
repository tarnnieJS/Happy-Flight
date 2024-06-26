package me.lab.happyflight.views.ui.home

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(context: Context, lifecycleScope: LifecycleCoroutineScope) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Go to compose UI"
    }
    val text: LiveData<String> = _text
}