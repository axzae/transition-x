package `in`.arunkumarsampath.transitionx.transition.slide

import androidx.transition.Slide
import `in`.arunkumarsampath.transitionx.transition.TransitionBuilder

/**
 * Builder for [Slide] transition.
 */
class SlideBuilder : TransitionBuilder<Slide>(Slide()) {

    var slideEdge: Int
        set(@GravityFlag value) {
            transition.slideEdge = value
        }

        @GravityFlag get() = transition.slideEdge
}
