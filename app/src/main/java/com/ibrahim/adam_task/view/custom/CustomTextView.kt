package com.ibrahim.adam_task.view.custom

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.ibrahim.adam_task.R
import android.util.DisplayMetrics





class CustomTextView : LinearLayout {

    var textDrawable: Drawable? = null
    val textView by lazy { findViewById<TextView>(R.id.textView) }
    val ivDrawable by lazy { findViewById<ImageView>(R.id.ivDrawable) }

    var textString: String? = ""
        set(value) {
            field = value
            invalidateTextPaintAndMeasurements()
        }

    var textColor: Int = Color.RED
        set(value) {
            field = value
            invalidateTextPaintAndMeasurements()
        }

    var textDimension = 14f
        set(value) {
            field = value
            invalidateTextPaintAndMeasurements()
        }

    var drawableMargin: Float = 0f
        set(value) {
            field = value
            invalidateTextPaintAndMeasurements()
        }


    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.sample_custom_text_view, this)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        // Load attributes
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.CustomTextView, defStyle, 0
        )

        textString = a.getString(
            R.styleable.CustomTextView_textString
        )
        textColor = a.getColor(
            R.styleable.CustomTextView_textColor,
            textColor
        )

        textDimension =
            if (a.hasValue(R.styleable.CustomTextView_textDimension)) {
                convertPixelsToDp(a.getDimensionPixelSize(R.styleable.CustomTextView_textDimension, textDimension.toInt()), context)
            }else{
                16f
            }

        drawableMargin = a.getDimension(R.styleable.CustomTextView_drawableMargin, drawableMargin)

        if (a.hasValue(R.styleable.CustomTextView_textDrawable)) {
            textDrawable = a.getDrawable(
                R.styleable.CustomTextView_textDrawable
            )
            textDrawable?.callback = this
        }

        a.recycle()

        Log.d("TAG", "init: $textDimension $textColor $textString $textDrawable")

        ivDrawable.setImageDrawable(textDrawable)
        textView.text = textString
        textView.textSize = textDimension
        ivDrawable.layoutParams = (ivDrawable.layoutParams as MarginLayoutParams).apply {
            marginEnd = drawableMargin.toInt()
        }
    }


    private fun invalidateTextPaintAndMeasurements() {

    }
}

fun convertPixelsToDp(px: Int, context: Context): Float {
    return px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}