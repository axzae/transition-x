package `in`.arunkumarsampath.transitionx.transition.changetext

import androidx.annotation.IntDef

/**
 * Annotation for all possible [ChangeText] animation types.
 */
@IntDef(
    value = [
        ChangeText.CHANGE_BEHAVIOR_IN,
        ChangeText.CHANGE_BEHAVIOR_OUT,
        ChangeText.CHANGE_BEHAVIOR_OUT_IN,
        ChangeText.CHANGE_BEHAVIOR_KEEP,
    ],
)
@Retention(AnnotationRetention.SOURCE)
annotation class ChangeTextBehavior
