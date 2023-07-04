@file:Suppress("NOTHING_TO_INLINE")

package `in`.arunkumarsampath.transitionx.sample.extensions

import androidx.fragment.app.Fragment

inline fun Fragment.dpToPx(dp: Double): Int {
    return requireContext().dpToPx(dp)
}
