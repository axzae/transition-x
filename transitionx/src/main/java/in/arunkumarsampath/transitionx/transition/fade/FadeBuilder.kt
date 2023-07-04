package `in`.arunkumarsampath.transitionx.transition.fade

import androidx.transition.Fade
import androidx.transition.Fade.IN
import androidx.transition.Fade.OUT
import androidx.transition.Visibility
import `in`.arunkumarsampath.transitionx.transition.TransitionBuilder

/**
 * Builder for [Fade] transition.
 *
 * @param fadingMode Specify on which visible mode the fade animation should trigger. The visible
 * mode is determined by [Visibility.isVisible]
 */
class FadeBuilder(@FadeMode fadingMode: Int = IN or OUT) : TransitionBuilder<Fade>(Fade(fadingMode))
