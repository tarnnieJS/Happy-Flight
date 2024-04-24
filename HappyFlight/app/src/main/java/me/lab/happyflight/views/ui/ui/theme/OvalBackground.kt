package me.lab.happyflight.views.ui.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun OvalBackground(
    modifier: Modifier = Modifier,
) {
    Canvas(modifier = modifier) {
        drawOval(
            color = Color.White,
            size = Size(size.width, size.height)
        )
        drawOval(
            color = Color.Red,
            style = Stroke(width = 1.dp.toPx()),
            size = Size(size.width, size.height)
        )
    }
}