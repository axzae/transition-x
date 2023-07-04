package `in`.arunkumarsampath.transitionx.sample.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.fragment.app.Fragment

fun Context.dpToPx(dp: Double): Int {
    val displayMetrics = resources.displayMetrics
    return (dp * displayMetrics.density + 0.5).toInt()
}

@ColorInt
fun Context.resolveColorRes(@ColorRes id: Int): Int {
    return ContextCompat.getColor(this, id)
}

fun Fragment.dpToPx(dp: Double): Int {
    return requireContext().dpToPx(dp)
}

fun View.toggleGone() {
    isGone = !isGone
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun View.removeCallbacks(vararg runnables: () -> Unit) = runnables.forEach { removeCallbacks(it) }
