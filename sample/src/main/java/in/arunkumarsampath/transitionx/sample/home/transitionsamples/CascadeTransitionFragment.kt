package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.databinding.LayoutCascadeTransitionBinding

class CascadeTransitionFragment : BaseSampleFragment() {

    private lateinit var binding: LayoutCascadeTransitionBinding
    override val contentLayoutResource = R.layout.layout_cascade_transition
    override val titleRes = R.string.cascade

    private var defaultState = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LayoutCascadeTransitionBinding.bind(viewStubRoot)
        initTransitionListeners()
    }

    private fun initTransitionListeners() {
        binding.fab.setOnClickListener {
            val constraint1 = ConstraintSet().apply {
                clone(requireContext(), R.layout.layout_cascade_transition)
            }
            val constraint2 = ConstraintSet().apply {
                clone(requireContext(), R.layout.layout_cascade_transition_alt)
            }
            binding.constraintLayout.prepareTransition {
                arrayOf(
                    binding.textView,
                    binding.textView2,
                    binding.textView3,
                    binding.textView4,
                ).forEachIndexed { position, view ->
                    moveResize {
                        +view
                        startDelay = ((position + 1) * 150).toLong()
                    }
                }
                moveResize { +binding.fab }
                ease {
                    decelerateEasing
                }
            }
            (if (defaultState) constraint1 else constraint2).applyTo(binding.constraintLayout)
            defaultState = !defaultState
        }
    }
}
