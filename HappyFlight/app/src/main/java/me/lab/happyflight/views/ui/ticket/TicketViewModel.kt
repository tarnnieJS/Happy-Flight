package me.lab.happyflight.views.ui.ticket

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.lab.happyflight.data.dummy.DummyData
import me.lab.happyflight.data.models.BookingDataModel

class TicketViewModel(context: Context, lifecycleScope: LifecycleCoroutineScope) : ViewModel() {

    val bookingData = MutableLiveData<List<BookingDataModel>>().apply {
        value =  DummyData().dummyBookingData
    }

}