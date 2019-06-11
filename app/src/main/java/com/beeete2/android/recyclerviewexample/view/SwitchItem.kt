package com.beeete2.android.recyclerviewexample.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.beeete2.android.recyclerviewexample.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class SwitchItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val switchCompat by lazy { findViewById<SwitchCompat>(R.id.switch_compat) }

    init {
        inflate(context, R.layout.item_switch, this)
    }

    @TextProp
    fun setLabel(label: CharSequence) {
        switchCompat.text = label
    }

}
