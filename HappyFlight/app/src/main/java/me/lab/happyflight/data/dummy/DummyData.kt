package me.lab.happyflight.data.dummy

import me.lab.happyflight.data.models.BookingDataModel

class DummyData {

    private val ticketTypeList = listOf(
        "ขาไป",
        "ขากลับ",
        "ขาไป",
        "ขากลับ",
        "ขาไป",
        "ขากลับ",
        "ขาไป",
        "ขากลับ",
        "ขาไป",
        "ขากลับ"
    )

    private val bookingID = listOf(
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10
    )

    val dummyBookingData = ticketTypeList.mapIndexed { index, ticketType  ->
        BookingDataModel(
            bookingId = bookingID[index],
            ticketType = ticketType,
            airPlaneType = if (index % 2 == 0) "Boeing 737-800" else "Airbus Nok A320",
            ticketClass = if (index % 3 == 0) "Economy" else if (index % 3 == 1) "Business" else "First",
            origin = if (index % 2 == 0) "กรุงเทพฯ" else "เชียงใหม่",
            destination = if (index % 2 == 0) "เชียงใหม่" else "กรุงเทพฯ",
            carryWeight = if (index % 2 == 0) "สัมภาระขึ้นเครื่อง 7 กก." else "สัมภาระขึ้นเครื่อง 10 กก.",
            airLine = if (index % 2 == 0) "AirAsia" else "NokAir",
            originAirPortEN = if (index % 2 == 0) "(DMK)" else "(CNX)",
            originAirPortTH = if (index % 2 == 0) "สนามบินดอนเมือง (DMK)" else "สนามบินเชียงใหม่(CNX)",
            destinationAirPortEN = if (index % 2 == 0) "(CNX)" else "(DMK)",
            destinationAirPortTH = if (index % 2 == 0) "สนามบินเชียงใหม่(CNX)" else "สนามบินดอนเมือง (DMK)",
            flightNumber = if (index % 2 == 0) "AirAsia FD3123" else "NokAir TG1234",
            flightDate = if (index % 2 == 0) "อา. 10 ธ.ค. 2024" else "อ. 12 ธ.ค. 2024",
            flightTime = if (index % 2 == 0) "21:05-22:15" else "10:30-11:40",
            takeOffDate = if (index % 2 == 0) "10 ธ.ค." else "12 ธ.ค.",
            takeOffTime = if (index % 2 == 0) "21:05" else "10:30",
            landingDate = if (index % 2 == 0) "10 ธ.ค." else "12 ธ.ค.",
            landingTime = if (index % 2 == 0) "22:15" else "11:40",
            totalTimeHrs = "1 ชม.",
            totalTimeMin = "10 น.",
            totalTicket = 1,
            isReturn = ticketType == "ขากลับ",
            isOneWay = ticketType == "ขาไป",
            isRoundTrip = false,
            isHaveWifi = true,
            isHaveChild = index % 2 == 0,
            isHavePet = false,
            isSelect = false,
            isPay = false,
        )
    }
}