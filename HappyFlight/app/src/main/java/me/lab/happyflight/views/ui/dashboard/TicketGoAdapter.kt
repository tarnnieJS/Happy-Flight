package me.lab.happyflight.views.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.lab.happyflight.R
import me.lab.happyflight.data.models.BookingDataModel
import me.lab.happyflight.databinding.ItemSelectTicketBinding

class TicketGoAdapter(
    private val bookings: List<BookingDataModel>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<TicketGoAdapter.BookingViewHolder>() {

    val selectedItems = mutableSetOf<Int>()
    private var selectedItemID: Int? = null


    interface OnItemClickListener {
        fun onBookingSelected(item: BookingDataModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        val binding = ItemSelectTicketBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BookingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        val booking = bookings[position]
        holder.bind(booking)
    }

    override fun getItemCount(): Int {
        return bookings.size
    }

    inner class BookingViewHolder(val binding: ItemSelectTicketBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private var booking: BookingDataModel? = null


        fun bind(booking: BookingDataModel) {
            this.booking = booking
            with(binding) {
                textViewTicketType.text = "เที่ยวบิน"
                textViewOrigin.text = "${booking.origin} ${booking.originAirPortEN}"
                textViewDestination.text =
                    "${booking.destination} ${booking.destinationAirPortEN}"
                textViewFlightDate.text = booking.flightDate
                textViewFlightTime.text = "${booking.flightTime} - ${booking.landingTime}"
                iconAirline.setImageResource(getAirlineIcon(booking.airLine))
                updateSelectionState()
                binding.root.setOnClickListener {
                    toggleSelection(adapterPosition)
                    itemClickListener.onBookingSelected(booking)
                    selectedItemID = booking.bookingId
                }
            }
        }

        private fun toggleSelection(position: Int) {
            if (selectedItems.contains(position)) {
                selectedItems.remove(position)
            } else {
                selectedItems.add(position)
            }
            updateSelectionState()
        }

        private fun updateSelectionState() {
            val isSelected = adapterPosition in selectedItems
            val backgroundColor =
                if (isSelected) R.drawable.background_border_green_frame_corner_16 else R.drawable.background_border_gray_corner_16
            binding.backgroundItem.setBackgroundResource(backgroundColor)
        }


        private fun getAirlineIcon(airline: String?): Int {
            return when (airline) {
                "AirAsia" -> R.drawable.airasia
                else -> R.drawable.ic_nokair
            }
        }
    }


}


