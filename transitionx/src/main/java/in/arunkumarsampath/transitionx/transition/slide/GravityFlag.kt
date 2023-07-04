package `in`.arunkumarsampath.transitionx.transition.slide

import android.annotation.SuppressLint
import android.view.Gravity
import androidx.annotation.IntDef
import kotlin.annotation.AnnotationRetention.SOURCE

@SuppressLint("RtlHardcoded")
@IntDef(
    Gravity.LEFT,
    Gravity.TOP,
    Gravity.RIGHT,
    Gravity.BOTTOM,
    Gravity.START,
    Gravity.END,
)
@Retention(SOURCE)
annotation class GravityFlag
