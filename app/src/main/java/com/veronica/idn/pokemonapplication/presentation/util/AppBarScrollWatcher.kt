package com.veronica.idn.pokemonapplication.presentation.util

import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.*
import kotlin.math.abs

class AppBarScrollWatcher(private val listener: (Boolean, Boolean, Int, Int, Float, Float) -> Unit) :
    OnOffsetChangedListener {
    private var scrollRange = -1
    override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
        if (scrollRange == -1) {
            scrollRange = appBarLayout.totalScrollRange
        }
        val appbarHeight = scrollRange + verticalOffset
        var alpha = appbarHeight.toFloat() / scrollRange
        if (alpha < 0) {
            alpha = 0f
        }
        val alphaZeroOnCollapsed = shrinkAlpha(alpha)
        val alphaZeroOnExpanded = abs(alphaZeroOnCollapsed - 1)
        val argbZeroOnExpanded = abs(alphaZeroOnCollapsed * 255 - 255).toInt()
        val argbZeroOnCollapsed = abs(alphaZeroOnCollapsed * 255).toInt()
        listener(
            alphaZeroOnExpanded <= 0,
            alphaZeroOnCollapsed <= 0,
            argbZeroOnExpanded,
            argbZeroOnCollapsed,
            alphaZeroOnCollapsed,
            alphaZeroOnExpanded
        )
    }

    private fun shrinkAlpha(alpha: Float): Float {
        val formatter = NumberFormat.getInstance(Locale.getDefault())
        formatter.maximumFractionDigits = 2
        formatter.minimumFractionDigits = 2
        formatter.roundingMode = RoundingMode.HALF_DOWN
        return formatter.format(alpha.toDouble()).toFloat()
    }
}