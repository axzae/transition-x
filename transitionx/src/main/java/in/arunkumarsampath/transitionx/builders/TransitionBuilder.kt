@file:Suppress("NOTHING_TO_INLINE")

package `in`.arunkumarsampath.transitionx.builders

import `in`.arunkumarsampath.transitionx.scope.TransitionBuilderMarker
import android.animation.TimeInterpolator
import android.support.transition.PathMotion
import android.support.transition.Transition
import android.view.View

@TransitionBuilderMarker
open class TransitionBuilder<T : Transition>(val transition: T) {
    var duration: Long
        get() = transition.duration
        set(value) {
            transition.duration = value
        }


    var startDelay: Long
        get() = transition.startDelay
        set(value) {
            transition.startDelay = value
        }


    var interpolator: TimeInterpolator?
        get() = transition.interpolator
        set(value) {
            transition.interpolator = value
        }

    var pathMotion: PathMotion?
        get() = transition.pathMotion
        set(value) {
            transition.setPathMotion(value)
        }

    inline operator fun String.unaryPlus() = transition.addTarget(this)

    inline operator fun <reified Type> Type.unaryPlus() = transition.addTarget(Type::class.java)

    inline operator fun View.unaryPlus() = transition.addTarget(this)
}
