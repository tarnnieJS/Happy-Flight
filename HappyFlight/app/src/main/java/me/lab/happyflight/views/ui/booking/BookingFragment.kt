package me.lab.happyflight.views.ui.booking

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.addCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import me.lab.happyflight.R
import me.lab.happyflight.databinding.FragmentBookingBinding
import me.lab.happyflight.views.ui.dashboard.DashboardFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.util.ArrayList

class BookingFragment : Fragment() {


    private var _binding: FragmentBookingBinding? = null
    private val binding get() = _binding!!

    private val tabTitles = arrayListOf("การจอง", "บริการเสริม", "ชำระเงิน","สำเร็จ")
    private val tabSteps = arrayListOf("1", "2", "3","4")


    private val bookingViewModel : BookingViewModel by viewModel { parametersOf(requireContext(),viewLifecycleOwner.lifecycleScope) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listOfBookingsID = arguments?.getIntegerArrayList("listBookingID")
        setUpLayoutWithViewPager(listOfBookingsID)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().popBackStack()
        }
        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.buttonFinish.setOnClickListener {
            findNavController().popBackStack()
        }

        if (listOfBookingsID != null) {
            listOfBookingsID.forEach {
                Log.d("TAG", "onViewCreated: $it")
            }
        }
    }

    private fun setUpLayoutWithViewPager(listOfBookingsID: ArrayList<Int>?) {
        binding.viewPager.adapter = BookingPagerAdapter(this@BookingFragment, listOfBookingsID)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
            if (tab.customView == null) {
                tab.customView = LayoutInflater.from(requireContext()).inflate(R.layout.tab_title, null) as ConstraintLayout
            }
            val textViewStep = tab.customView?.findViewById<TextView>(R.id.textStepBar)
            val textViewDescription = tab.customView?.findViewById<TextView>(R.id.textStepBarDescription)
            textViewStep?.text = tabSteps[position] // Set step number
            textViewDescription?.text = tabTitles[position] // Set description
            tab.view.setOnClickListener {
                binding.viewPager.setCurrentItem(position, true)
            }
            if (position == 0) {
                updateTabAppearance(tab, true)
            } else {
                updateTabAppearance(tab, false)

            }
        }.attach()
        binding.tabLayout.getTabAt(0)?.select()
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    updateTabAppearance(tab, true)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.let {
                    updateTabAppearance(tab, false)
                }
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
    private fun updateTabAppearance(tab: TabLayout.Tab, isSelected: Boolean) {
        val textViewStep = tab.customView?.findViewById<TextView>(R.id.textStepBar)
        val textViewDescription = tab.customView?.findViewById<TextView>(R.id.textStepBarDescription)
        if (isSelected) {
            textViewStep?.setBackgroundResource(R.drawable.bg_cycle_red)
            textViewStep?.setTextColor(Color.RED)
            textViewDescription?.setTextColor(Color.RED)
        }
        else {
            textViewStep?.setBackgroundResource(R.drawable.bg_cycle_gray)
            textViewStep?.setTextColor(resources.getColor(R.color.text_secondary))
            textViewDescription?.setTextColor(resources.getColor(R.color.text_secondary))
        }
        if (tab.position == 3){
            binding.buttonFinish.visibility = View.VISIBLE
        }else{
            binding.buttonFinish.visibility = View.GONE
        }
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}