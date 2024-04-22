package me.lab.happyflight.data.models

data class BookingDataModel(
    val bookingId: Int?,
    val ticketType: String?, // go and return
    val airPlaneType: String?,
    val ticketClass: String?, //economy, business, first
    val origin: String?, //Bangkok, Bangkok, Bangkok
    val destination: String?, //Chaing Mai, Chaing Mai, Chaing Mai
    val carryWeight: String?, //7 kg

    val airLine: String?, // airAsia, airAsia, airAsia

    val originAirPortEN: String?, //DMK
    val originAirPortTH: String?, //สนามบินดอนเมือง (DMK)

    val destinationAirPortEN: String?, // (CNX)
    val destinationAirPortTH: String?,//สนามบินเชียงใหม่

    val flightNumber: String?,//Boeing 737-800

    val flightDate: String?,//10 ธ.ค.
    val flightTime: String?,//21:05

    val takeOffDate: String?,//10 ธ.ค.
    val takeOffTime: String?,//21:05

    val landingDate: String?,//10 ธ.ค.
    val landingTime: String?,//22:15

    val totalTimeHrs: String?,//1 ชั่วโมง 10 นาที
    val totalTimeMin: String?,//10 นาที
    val totalTicket: Int?,//2

    val isReturn: Boolean?,//true
    val isOneWay: Boolean?,
    val isRoundTrip: Boolean?,
    val isHaveWifi: Boolean?,
    val isHaveChild: Boolean?,
    val isHavePet: Boolean?,

    var isSelect: Boolean?,
    val isPay: Boolean?,

    )
