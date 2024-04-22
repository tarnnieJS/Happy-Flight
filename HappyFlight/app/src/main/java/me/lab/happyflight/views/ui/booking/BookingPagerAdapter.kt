package me.lab.happyflight.views.ui.booking

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import me.lab.happyflight.views.ui.addonservice.AddOnServiceFragment
import me.lab.happyflight.views.ui.payment.PaymentFragment
import me.lab.happyflight.views.ui.summary.SummaryFragment
import me.lab.happyflight.views.ui.ticket.TicketFragment
import java.util.ArrayList

class BookingPagerAdapter(fragment:Fragment, private val listBookingID: ArrayList<Int>?) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0 -> {
               TicketFragment(listBookingID)
           }
           1 -> {
               AddOnServiceFragment()
           }
           2 -> {
               PaymentFragment()
           }else ->{
               SummaryFragment()
           }

       }
    }

}