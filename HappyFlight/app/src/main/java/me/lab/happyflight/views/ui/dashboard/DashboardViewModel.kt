package me.lab.happyflight.views.ui.dashboard

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import me.lab.happyflight.data.dummy.DummyData
import me.lab.happyflight.data.models.BookingDataModel

class DashboardViewModel(  context: Context, private val lifecycleScope: LifecycleCoroutineScope) : ViewModel() {

    val bookingData = MutableLiveData<List<BookingDataModel>>().apply {
        value =  DummyData().dummyBookingData
    }

    var listOfTicketID = MutableLiveData<MutableList<Int>>(mutableListOf())
    val totalTicketGO = MutableLiveData<MutableList<Int>>(mutableListOf())
    val totalTicketReturn = MutableLiveData<MutableList<Int>>(mutableListOf())

    val totalTicket = MutableLiveData<Int>().apply {
        value = listOfTicketID.value!!.size
    }

    fun addTicketTyeGo(id: Int){
        MainScope().launch {
            totalTicketGO.apply {
                value?.add(id)
            }
        }
    }

    fun addTicketTyeReturn(id: Int){
        MainScope().launch {
            totalTicketReturn.apply {
                value?.add(id)
            }
        }
    }

    fun removeTicketTyeGo(id: Int){
        MainScope().launch {
            totalTicketGO.apply {
                value?.remove(id)
            }
        }
    }

    fun removeTicketTyeReturn(id: Int){
        MainScope().launch {
            totalTicketReturn.apply {
                value?.remove(id)
            }
        }
    }



    fun addTicket(id: Int) {
        MainScope().launch {
            listOfTicketID.apply {
                value?.add(id)
            }
        }
    }

    fun removeTicket(id: Int){
        MainScope().launch {
            listOfTicketID.apply {
                value?.remove(id)
            }
        }

    }

}