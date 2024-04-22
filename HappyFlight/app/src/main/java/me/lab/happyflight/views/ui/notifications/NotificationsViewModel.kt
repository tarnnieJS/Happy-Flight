package me.lab.happyflight.views.ui.notifications

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel(context: Context, lifecycleScope: LifecycleCoroutineScope) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "No Have Notifications"
    }
    val text: LiveData<String> = _text
}