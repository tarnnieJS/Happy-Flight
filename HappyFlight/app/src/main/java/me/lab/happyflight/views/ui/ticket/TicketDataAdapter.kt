package me.lab.happyflight.views.ui.ticket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.lab.happyflight.R
import me.lab.happyflight.data.models.BookingDataModel
import me.lab.happyflight.databinding.ItemTicketReviewBinding

class TicketDataAdapter(private val bookingDataList: List<BookingDataModel>) :
    RecyclerView.Adapter<TicketDataAdapter.ViewHolder>() {

         var isHideItem : Boolean = true

    inner class ViewHolder(val binding: ItemTicketReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(bookingData: BookingDataModel) {
            // Bind data to views using view binding
            binding.apply {
                if (bookingData.isReturn == true) {
                    imageViewBackgroundTitle.setImageResource(R.drawable.ic_airplane_go)
                } else {
                    imageViewBackgroundTitle.setImageResource(R.drawable.ic_airplane_back)
                }
                if (bookingData.isHaveWifi == true){
                     textViewWiFi.visibility = View.VISIBLE
                }else{
                    textViewWiFi.visibility = View.GONE
                }

                textViewBookingType.text = bookingData.ticketType
                textViewCardBookingType.text = bookingData.ticketType
                textViewOriginAirPort.text = bookingData.origin + bookingData.originAirPortEN
                textViewDestinationAirPort.text =
                    bookingData.destination + bookingData.destinationAirPortEN
                textViewAirportNameOrigin.text = bookingData.originAirPortTH
                textViewAirportNameDestination.text = bookingData.destinationAirPortTH
                textViewOrigin.text = bookingData.origin
                textViewDestination.text = bookingData.destination
                textViewOrigin2.text = bookingData.origin
                textViewDestination2.text = bookingData.destination
                textViewBookingDate.text = bookingData.flightDate
                textViewBookingTime.text = bookingData.flightTime
                imageViewAirlineLogo1.setImageResource(getAirlineIcon(bookingData.airLine))
                imageViewAirlineLogo2.setImageResource(getAirlineIcon(bookingData.airLine))
                imageViewAirlineLogo3.setImageResource(getAirlineIcon(bookingData.airLine))
                textViewTakeOffTime.text = bookingData.takeOffTime
                textViewTakeOfDate.text = bookingData.takeOffDate
                textViewLandingTime.text = bookingData.landingTime
                textViewLandingDate.text = bookingData.landingDate
                textViewAirlineCode.text = bookingData.flightNumber
                textViewAirPlaneCode.text = bookingData.airPlaneType
                textViewTicketClass.text = bookingData.ticketClass
                textViewCarryOn.text = bookingData.carryWeight
                totalTime.text = "${bookingData.totalTimeHrs}\n${bookingData.totalTimeMin}"


            }

        }

        private fun getAirlineIcon(airline: String?): Int {
            return when (airline) {
                "AirAsia" -> R.drawable.airasia
                else -> R.drawable.ic_nokair
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTicketReviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val customLineView = binding.customLineView
        val viewA = binding.imageView2
        val viewB = binding.endDashLine
        customLineView.setViews(viewA, viewB)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = bookingDataList[position]
        holder.bind(currentItem)

        if (isHideItem) {
            holder.binding.cardViewBookingReviewDetails.visibility = View.VISIBLE
            holder.binding.layoutItemShortVersion.visibility = View.GONE
        } else {
            holder.binding.cardViewBookingReviewDetails.visibility = View.GONE
            holder.binding.layoutItemShortVersion.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return bookingDataList.size
    }

}
