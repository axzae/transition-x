@file:Suppress("NOTHING_TO_INLINE")

package `in`.arunkumarsampath.transitionx.sample.extensions

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

inline fun Context.dpToPx(dp: Double): Int {
    val displayMetrics = resources.displayMetrics
    return (dp * displayMetrics.density + 0.5).toInt()
}

@ColorInt
inline fun Context.resolveColorRes(@ColorRes id: Int): Int {
    return ContextCompat.getColor(this, id)
}
