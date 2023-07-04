package `in`.arunkumarsampath.transitionx.easing

import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import `in`.arunkumarsampath.transitionx.scope.TransitionBuilderMarker

/**
 * Proxy object to scope adding inbuilt interpolators provided with the support library.
 */
@TransitionBuilderMarker
object Easing {
    /**
     * Material Design standard's Standard Easing([FastOutSlowInInterpolator])
     *
     * This easing is recommended for Views that **move within visible area of the layout.**
     *
     * More details: [Easing on Material.io](https://material.io/design/motion/speed.html#easing)
     */
    val standardEasing get() = FastOutSlowInInterpolator()

    /**
     * Material Design standard's Decelerate Easing([LinearOutSlowInInterpolator])
     *
     * This easing is recommended for Views that **appear/enter outside visible bounds of the layout.**
     * Example: *Snackbar message from bottom of the screen*
     *
     * More details: [Easing on Material.io](https://material.io/design/motion/speed.html#easing)
     */
    val decelerateEasing get() = LinearOutSlowInInterpolator()

    /**
     * Material Design standard's Accelerate Easing([FastOutLinearInInterpolator])
     *
     * This easing is recommended for Views that **exit visible bounds of the layout.**
     * Example: *Disappear bottom sheet*
     *
     * More details: [Easing on Material.io](https://material.io/design/motion/speed.html#easing)
     */
    val accelerateEasing get() = FastOutLinearInInterpolator()
}
