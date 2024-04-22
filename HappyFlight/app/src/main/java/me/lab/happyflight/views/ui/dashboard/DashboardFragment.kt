package me.lab.happyflight.views.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import me.lab.happyflight.R
import me.lab.happyflight.data.models.BookingDataModel
import me.lab.happyflight.databinding.FragmentDashboardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.util.ArrayList

class DashboardFragment : Fragment() ,TicketGoAdapter.OnItemClickListener ,TicketReturnAdapter.OnItemClickListener{

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private lateinit var bookingAdapter: TicketGoAdapter
    private lateinit var bookingReturnAdapter: TicketReturnAdapter

    private val dashboardViewModel : DashboardViewModel by viewModel { parametersOf(requireContext(),viewLifecycleOwner.lifecycleScope) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onResume() {
        super.onResume()
        dashboardViewModel.listOfTicketID.value!!.clear()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dashboardViewModel.bookingData.observe(viewLifecycleOwner) {
            bookingAdapter = TicketGoAdapter(it.filter { it.isReturn == false },this@DashboardFragment)
            binding.recyclerViewSelectTicket.apply {
                adapter = bookingAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            bookingReturnAdapter = TicketReturnAdapter(it.filter { it.isReturn == true },this@DashboardFragment)
            binding.recyclerViewSelectTicketReturn.apply {
                adapter = bookingReturnAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
        binding.apply {
            buttonSelectTicket.setOnClickListener {
                if ( dashboardViewModel.listOfTicketID.value?.size != 0) {
//                    Toast.makeText(requireContext(), dashboardViewModel.listOfTicketID.value?.size.toString(), Toast.LENGTH_SHORT).show()
                    val bundle = Bundle().apply {
                        putIntegerArrayList("listBookingID",
                            dashboardViewModel.listOfTicketID.value as ArrayList<Int>?
                        )
                    }
                    findNavController().navigate(R.id.action_fragment_dashboard_to_fragment_booking, bundle)
                } else {
                    Toast.makeText(requireContext(), "You have no select ticket", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onBookingSelected(item: BookingDataModel) {
        Log.e("TAG", "onBookingSelected: " + dashboardViewModel.listOfTicketID.value?.size)
        binding.recyclerViewSelectTicketReturn.visibility = View.VISIBLE
        val isItemInList = dashboardViewModel.listOfTicketID.value?.contains(item.bookingId) ?: false
        if (isItemInList) {
            dashboardViewModel.removeTicket(item.bookingId!!.toInt())
            dashboardViewModel.removeTicketTyeGo(item.bookingId.toInt())
        } else {
            dashboardViewModel.addTicket(item.bookingId!!.toInt())
            dashboardViewModel.addTicketTyeGo(item.bookingId.toInt())

        }
    }

    override fun onBookingReturnSelected(item: BookingDataModel) {
        val isItemInList = dashboardViewModel.listOfTicketID.value?.contains(item.bookingId) ?: false
        if (isItemInList) {
            dashboardViewModel.removeTicket(item.bookingId!!.toInt())
            dashboardViewModel.removeTicketTyeReturn(item.bookingId!!.toInt())

        } else {
            dashboardViewModel.addTicket(item.bookingId!!.toInt())
            dashboardViewModel.addTicketTyeReturn(item.bookingId.toInt())
        }

    }
}