package `in`.arunkumarsampath.transitionx.transition.set

import androidx.transition.AutoTransition
import androidx.transition.TransitionSet


/**
 * Base builder for building a [TransitionSet]
 */
class DefaultTransitionSetBuilder : TransitionSetBuilder<TransitionSet>(TransitionSet())

/**
 * Builder for building a [TransitionSet] with [AutoTransition] already added.
 */
class AutoTransitionBuilder : TransitionSetBuilder<TransitionSet>(AutoTransition())
