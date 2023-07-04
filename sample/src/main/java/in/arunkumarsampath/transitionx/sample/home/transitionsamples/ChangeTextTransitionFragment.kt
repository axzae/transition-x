package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.os.Bundle
import android.view.View
import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.databinding.LayoutChangeTextTransitionBinding
import `in`.arunkumarsampath.transitionx.transition.changetext.ChangeText

class ChangeTextTransitionFragment : BaseSampleFragment() {

    private lateinit var binding: LayoutChangeTextTransitionBinding
    override val contentLayoutResource = R.layout.layout_change_text_transition
    override val titleRes = R.string.change_text_transition

    private val mockStrings = listOf(
        R.string.lorem_ipsum,
        R.string.vivamus_bibendum,
        R.string.pellentesque_mattis,
        R.string.change_text_transition,
    )

    private var counter: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LayoutChangeTextTransitionBinding.bind(viewStubRoot)
        initTransitionListeners()
    }

    private fun initTransitionListeners() {
        binding.fab.setOnClickListener {
            binding.constraintLayout.prepareTransition {
                changeText {
                    changeTextBehavior = ChangeText.CHANGE_BEHAVIOR_OUT_IN
                }
                +binding.textView
            }
            binding.textView.setText(mockStrings[++counter % mockStrings.size])
        }
    }
}
