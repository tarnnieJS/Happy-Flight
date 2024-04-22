package me.lab.happyflight.views.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView

class CustomLineView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint()
    private var viewA: ImageView? = null
    private var viewB: ImageView? = null

    init {
        paint.color = android.graphics.Color.RED // Set your desired color
        paint.strokeWidth = 5f // Set your desired line width
        paint.pathEffect = android.graphics.DashPathEffect(floatArrayOf(20f, 10f), 0f) // Set dash effect
    }

    fun setViews(viewA: ImageView, viewB: ImageView) {
        this.viewA = viewA
        this.viewB = viewB
        invalidate() // Redraw the view once the views are set
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        viewA?.let { viewA ->
            viewB?.let { viewB ->
                // Calculate the midpoint X coordinate
                val midX = (viewA.x + viewA.width / 2 + viewB.x + viewB.width / 2) / 2

                // Calculate the top Y coordinate (minimum of the two views)
                val startY = minOf(viewA.y, viewB.y) + viewA.height

                // Calculate the bottom Y coordinate (maximum of the two views)
                val endY = maxOf(viewA.y + viewA.height, viewB.y + viewB.height)

                // Draw dashed line vertically between ViewA and ViewB
                canvas.drawLine(midX, startY.toFloat(), midX, endY.toFloat(), paint)
            }
        }
    }

}



