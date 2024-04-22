package me.lab.happyflight.views.ui.ticket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import me.lab.happyflight.R
import me.lab.happyflight.databinding.FragmentTicketBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf




 class TicketFragment(private val listBookingID: ArrayList<Int>?) : Fragment() {


     private var _binding: FragmentTicketBinding? = null
    private val binding get() = _binding!!

    private lateinit var bookingAdapter: TicketDataAdapter
     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)
         val ticketViewModel : TicketViewModel by viewModel { parametersOf(requireContext(),viewLifecycleOwner.lifecycleScope) }

         ticketViewModel.bookingData.observe(viewLifecycleOwner) {
             bookingAdapter = TicketDataAdapter(it.filter { booking -> listBookingID!!.contains(booking.bookingId) })
             binding.recyclerViewTicket.apply {
                 adapter = bookingAdapter
                 layoutManager = LinearLayoutManager(requireContext())
             }
         }
         binding.buttonHideDetailBokking.setOnClickListener {
             bookingAdapter.isHideItem = !bookingAdapter.isHideItem
             if (bookingAdapter.isHideItem)
                 binding.buttonHideDetailBokking.setImageResource(R.drawable.chevron_up)
             else{
                 binding.buttonHideDetailBokking.setImageResource(R.drawable.chevron_down)
             }
             bookingAdapter.notifyDataSetChanged()
         }
     }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}