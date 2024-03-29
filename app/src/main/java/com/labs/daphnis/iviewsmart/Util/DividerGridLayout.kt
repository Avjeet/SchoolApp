package com.labs.daphnis.iviewsmart.Util


import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.GridLayout
import com.labs.daphnis.iviewsmart.R

/**
 * Created by Avjeet on 16-01-2019.
 */
class DividerGridLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    GridLayout(context, attrs, defStyle) {


    private var vPaint: Paint? = null
    private var hPaint: Paint? = null

    init {
        init()
    }

    override fun dispatchDraw(canvas: Canvas) {
        val count = childCount
        for (i in 0 until count) {
            val view = getChildAt(i)
            val left = view.left
            val top = view.top
            val bottom = view.bottom
            val right = view.right


            if (i % columnCount == 0) {
                canvas.drawLine((right - 1).toFloat(), top.toFloat(), (right - 1).toFloat(), bottom.toFloat(), vPaint!!)
            } else if (i % columnCount == columnCount - 1) {
                canvas.drawLine(left.toFloat(), top.toFloat(), left.toFloat(), bottom.toFloat(), vPaint!!)
            } else {
                canvas.drawLine((right - 1).toFloat(), top.toFloat(), (right - 1).toFloat(), bottom.toFloat(), vPaint!!)
                canvas.drawLine(left.toFloat(), top.toFloat(), left.toFloat(), bottom.toFloat(), vPaint!!)
            }
            if (i >= columnCount)
                canvas.drawLine(left.toFloat(), top.toFloat(), right.toFloat(), top.toFloat(), hPaint!!)
        }
        super.dispatchDraw(canvas)
    }

    private fun init() {
        vPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        vPaint!!.color = ContextCompat.getColor(context,R.color.grid_sep_color_grey)
        vPaint!!.style = Paint.Style.STROKE
        vPaint!!.strokeWidth = 1.0f
        hPaint = Paint(vPaint)
        hPaint!!.strokeWidth = 2.0f
    }
}
