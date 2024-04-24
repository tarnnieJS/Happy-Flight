package me.lab.happyflight.views.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.lab.happyflight.R
import me.lab.happyflight.views.ui.ui.theme.ColorTextSecondary
import me.lab.happyflight.views.ui.ui.theme.DarkGray
import me.lab.happyflight.views.ui.ui.theme.HappyFlightTheme
import me.lab.happyflight.views.ui.ui.theme.LightGray
import me.lab.happyflight.views.ui.ui.theme.RedPrimary
import me.lab.happyflight.views.ui.ui.theme.RedSecondary
import me.lab.happyflight.views.ui.ui.theme.sukhumvitSet

class TicketUIActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyFlightTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp)
                ) {
                    ScaffoldView()

                }
            }
        }

    }
}


@Composable
fun ScaffoldView() {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),

            verticalArrangement = Arrangement.spacedBy(0.dp),
        ) {
            Row(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chevron_down),
                    contentDescription = null,
                    modifier = Modifier
                        .rotate(90f),
                )
                Text(
                    fontSize = 18.sp,
                    fontFamily = sukhumvitSet,
                    fontWeight = FontWeight.Bold,
                    text = "สรุปรายการจองตั๋วเครื่องบิน",
                    modifier = Modifier,
                    textAlign = TextAlign.Center,
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 24.dp,
                        top = 16.dp,
                        bottom = 8.dp,
                        end = 8.dp
                    ), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextWithOvalBackground(
                        text = "1",
                        textColor = RedPrimary,
                        strokeColor = RedPrimary,
                        fillColor = RedSecondary
                    )
                    Text(
                        color = RedPrimary,
                        fontSize = 12.sp,
                        fontFamily = sukhumvitSet,
                        fontWeight = FontWeight.ExtraBold,
                        text = "การจอง",
                    )
                }
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.width(30.dp)
                )
                Column(
                    modifier = Modifier.padding(
                        start = 8.dp,
                        top = 16.dp,
                        bottom = 8.dp,
                        end = 8.dp
                    ), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextWithOvalBackground(
                        text = "2",
                        textColor = DarkGray,
                        strokeColor = DarkGray,
                        fillColor = LightGray
                    )
                    Text(
                        color = DarkGray,
                        fontSize = 12.sp,
                        fontFamily = sukhumvitSet,
                        fontWeight = FontWeight.ExtraBold,
                        text = "บริการเสริม",
                    )
                }
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.width(30.dp)
                )
                Column(
                    modifier = Modifier.padding(
                        start = 8.dp,
                        top = 16.dp,
                        bottom = 8.dp,
                        end = 8.dp
                    ), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextWithOvalBackground(
                        text = "3",
                        textColor = DarkGray,
                        strokeColor = DarkGray,
                        fillColor = LightGray
                    )
                    Text(
                        color = DarkGray,
                        fontSize = 12.sp,
                        fontFamily = sukhumvitSet,
                        fontWeight = FontWeight.ExtraBold,
                        text = "ชำระเงิน",
                    )
                }
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.width(30.dp)
                )
                Column(
                    modifier = Modifier.padding(
                        start = 8.dp,
                        top = 16.dp,
                        bottom = 8.dp,
                        end = 24.dp
                    ), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextWithOvalBackground(
                        text = "4",
                        textColor = DarkGray,
                        strokeColor = DarkGray,
                        fillColor = LightGray
                    )
                    Text(
                        color = DarkGray,
                        fontSize = 12.sp,
                        fontFamily = sukhumvitSet,
                        fontWeight = FontWeight.ExtraBold,
                        text = "สำเร็จ",
                    )
                }

            }
            Divider(color = Color.Gray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    fontSize = 14.sp,
                    fontFamily = sukhumvitSet,
                    fontWeight = FontWeight.Bold,
                    text = "เที่ยวบินทั้งหมดที่คุณเลือก",
                    modifier = Modifier.weight(1f), // Make the Text composable expand to fill available space
                    textAlign = TextAlign.Start
                )
                Image(
                    painter = painterResource(id = R.drawable.chevron_up),
                    contentDescription = null,
                    modifier = Modifier
                )
            }
            Card(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
                Column(Modifier.padding(bottom = 16.dp)) {
                    BookingReviewDetailsCardTitle()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.airasia),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            fontSize = 14.sp,
                            fontFamily = sukhumvitSet,
                            text = "กรุงเทพฯ",
                            color = Color.Black,
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.arrow_right),
                            contentDescription = null,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            fontSize = 14.sp,
                            fontFamily = sukhumvitSet,
                            text = "เชียงใหม่",
                            color = Color.Black,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    TextImageTextRow(drawableId = R.drawable.menu_icon, text1 = "21:05", text2 = "กรุงเทพฯ")
                    TextRow( text1 = "10 ธ.ค.", text2 = "สนามบินดอนเมือง (DMK)")
                    Row(  modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 0.dp, start = 16.dp, end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            fontSize = 12.sp,
                            fontFamily = sukhumvitSet,
                            text = "1 ชม.\n" + "10 น.",
                            color = ColorTextSecondary,
                            modifier = Modifier.padding(start = 8.dp, end = 24.dp)
                        )
                        FlightDetails()
                    }
                    TextImageTextRow(drawableId = R.drawable.location_solid, text1 = "22:05", text2 = "เชียงใหม่")
                    TextRow( text1 = "10 ธ.ค.", text2 = "สนามบินเชียงใหม่ (CNX)")
                }
            }

        }
    }
}

@Composable
fun TextWithOvalBackground(text: String, textColor: Color, strokeColor: Color, fillColor: Color) {
    val strokeWidth = 1.dp
    val cornerRadius = 360.dp

    Box(
        modifier = Modifier
            .size(27.dp)
            .background(
                color = fillColor,
                shape = RoundedCornerShape(cornerRadius)
            )
            .border(
                width = strokeWidth,
                color = strokeColor,
                shape = RoundedCornerShape(cornerRadius)
            )
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center), // Center the text vertically and horizontally
            color = textColor,
            fontSize = 12.sp,
            fontFamily = sukhumvitSet,
            fontWeight = FontWeight.ExtraBold,
            text = text,
        )
    }
}


@Composable
fun FlightDetails(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(start = 8.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.airasia),
                contentDescription = null,
                modifier = Modifier.size(14.dp)
            )
            Text(
                fontSize = 14.sp,
                fontFamily = sukhumvitSet,
                text = "แอร์ เอเชีย DD140",
                color = Color.Black,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.airplane),
                contentDescription = null,
                modifier = Modifier.size(14.dp)
            )
            Text(
                fontSize = 14.sp,
                fontFamily = sukhumvitSet,
                text = "Boeing 737-800",
                color = Color.Black,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.booking_class),
                contentDescription = null,
                modifier = Modifier.size(14.dp)
            )
            Text(
                fontSize = 14.sp,
                fontFamily = sukhumvitSet,
                text = "Economy-Nok Lite",
                color = Color.Black,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.carry_on),
                contentDescription = null,
                modifier = Modifier.size(14.dp)
            )
            Text(
                fontSize = 14.sp,
                fontFamily = sukhumvitSet,
                text = "สัมภาระขึ้นเครื่อง 7 กก.",
                color = Color.Black,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_wifi),
                contentDescription = null,
                modifier = Modifier.size(14.dp)
            )
            Text(
                fontSize = 14.sp,
                fontFamily = sukhumvitSet,
                text = "WiFi",
                color = Color.Black,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

    }
}

@Composable
fun BookingReviewDetailsCardTitle(modifier: Modifier = Modifier) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth() ,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bg),
                        contentDescription = null,
                        modifier = Modifier.scale(scaleX = 1.3f, scaleY = 1f)
                    )
                    Row(Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = R.drawable.title_site_bar),
                            contentDescription = null, // Provide a content description
                            modifier = Modifier
                        )
                        Spacer(modifier = Modifier.weight(1f)) // Add a spacer with weight 1
                        Image(
                            painter = painterResource(id = R.drawable.ic_airplane_go),
                            contentDescription = null,
                            modifier = Modifier
                        )
                    }

                    Row(
                        modifier = Modifier.padding(top = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                        Text(
                            fontFamily = sukhumvitSet,
                            text = "เที่ยวบิน",
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        Text(
                            fontFamily = sukhumvitSet,
                            text = "ขาไป",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 8.dp)
                        )

                    }

                }

            }

        }
    }

@Composable
fun TextImageTextRow(
    modifier: Modifier = Modifier,
    drawableId: Int? = null,
    text1: String,
    text2: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 0.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            fontSize = 14.sp,
            fontFamily = sukhumvitSet,
            text = text1,
            color = Color.Black,
            modifier = Modifier.padding(start = 8.dp, end = 4.dp)
        )
        if (drawableId != null) {
            Image(
                painter = painterResource(id = drawableId),
                contentDescription = null,
                modifier = Modifier.size(14.dp)
            )
        }
        Text(
            fontSize = 14.sp,
            fontFamily = sukhumvitSet,
            text = text2,
            color = Color.Black,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}
@Composable
fun TextRow(
    modifier: Modifier = Modifier,
    text1: String,
    text2: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 0.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            fontSize = 12.sp,
            fontFamily = sukhumvitSet,
            text = text1,
            color = ColorTextSecondary,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        )
        Text(
            fontSize = 12.sp,
            fontFamily = sukhumvitSet,
            text = text2,
            color = ColorTextSecondary,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}




