package `in`.arunkumarsampath.transitionx.transition.common

import androidx.transition.ChangeBounds
import androidx.transition.ChangeClipBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.ChangeScroll
import androidx.transition.ChangeTransform
import androidx.transition.Explode
import `in`.arunkumarsampath.transitionx.transition.TransitionBuilder
import `in`.arunkumarsampath.transitionx.transition.changecolor.ChangeColor

/**
 * Builder for [ChangeTransform]
 */
class ScaleRotateBuilder : TransitionBuilder<ChangeTransform>(ChangeTransform())

/**
 * Builder for [ChangeClipBounds]
 */
class ChangeClipBoundsBuilder : TransitionBuilder<ChangeClipBounds>(ChangeClipBounds())

/**
 * Builder for [ChangeBounds]
 */
class ChangeBoundsBuilder : TransitionBuilder<ChangeBounds>(ChangeBounds())

/**
 * Builder for [ChangeImageTransform]
 */
class ChangeImageBuilder : TransitionBuilder<ChangeImageTransform>(ChangeImageTransform())

/**
 * Builder for [ChangeScroll]
 */
class ChangeScrollBuilder : TransitionBuilder<ChangeScroll>(ChangeScroll())

/**
 * Builder for [Explode]
 */
class ExplodeBuilder : TransitionBuilder<Explode>(Explode())

/**
 * Builder for [ChangeColor]
 */
class ChangeColorBuilder : TransitionBuilder<ChangeColor>(ChangeColor())
