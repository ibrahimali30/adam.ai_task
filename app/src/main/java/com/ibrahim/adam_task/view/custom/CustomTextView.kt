package com.ibrahim.adam_task.view.custom

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ibrahim.adam_task.R


class CustomTextView : LinearLayout {

    var textDrawable: Drawable? = null

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

    var textDimension: Float = 16f
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

        textDimension = a.getDimension(
            R.styleable.CustomTextView_textDimension,
            textDimension
        )

        if (a.hasValue(R.styleable.CustomTextView_textDrawable)) {
            textDrawable = a.getDrawable(
                R.styleable.CustomTextView_textDrawable
            )
            textDrawable?.callback = this
        }

        a.recycle()

    }


    private fun invalidateTextPaintAndMeasurements() {

    }
}