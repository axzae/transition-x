package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.ConstraintSet
import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.R
import kotlinx.android.synthetic.main.layout_cascade_transition.*

class CascadeTransitionFragment : BaseSampleFragment() {

    override val contentLayoutResource = R.layout.layout_cascade_transition
    override val titleRes = R.string.cascade

    private var defaultState = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTransitionListeners()
    }

    private fun initTransitionListeners() {
        fab.setOnClickListener {
            val constraint1 = ConstraintSet().apply {
                clone(requireContext(), R.layout.layout_cascade_transition)
            }
            val constraint2 = ConstraintSet().apply {
                clone(requireContext(), R.layout.layout_cascade_transition_alt)
            }
            constraintLayout.prepareTransition {
                arrayOf(
                    textView,
                    textView2,
                    textView3,
                    textView4,
                ).forEachIndexed { position, view ->
                    moveResize {
                        +view
                        startDelay = ((position + 1) * 150).toLong()
                    }
                }
                moveResize { +fab }
                ease {
                    decelerateEasing
                }
            }
            (if (defaultState) constraint1 else constraint2).applyTo(constraintLayout)
            defaultState = !defaultState
        }
    }
}
