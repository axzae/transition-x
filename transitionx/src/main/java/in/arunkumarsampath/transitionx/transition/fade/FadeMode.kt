package `in`.arunkumarsampath.transitionx.transition.fade

import androidx.annotation.IntDef
import androidx.transition.Fade.IN
import androidx.transition.Fade.OUT

@IntDef(flag = true, value = [IN, OUT, IN or OUT])
@Retention(AnnotationRetention.SOURCE)
annotation class FadeMode
