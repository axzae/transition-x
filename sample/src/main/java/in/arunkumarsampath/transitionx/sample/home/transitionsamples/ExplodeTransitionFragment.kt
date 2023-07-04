package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isGone
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.databinding.FragmentExplodeTransitionBinding
import `in`.arunkumarsampath.transitionx.sample.utils.dpToPx

class ExplodeTransitionFragment : Fragment() {

    private lateinit var binding: FragmentExplodeTransitionBinding
    private var toggle = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentExplodeTransitionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewListeners()
    }

    private fun initViewListeners() {
        binding.layoutContent.fab.setOnClickListener {
            binding.layoutContent.frameLayout.prepareTransition {
                explode {
                    +binding.layoutContent.accentBackground
                }
                moveResize {
                    +binding.layoutContent.userIconView
                }
            }

            if (toggle) {
                with(requireContext()) {
                    binding.layoutContent.userIconView.updateLayoutParams<LinearLayout.LayoutParams> {
                        height = dpToPx(112.0)
                        width = dpToPx(112.0)
                    }
                }
                binding.layoutContent.accentBackground.isGone = true
                binding.layoutContent.helloText.isGone = false
            } else {
                with(requireContext()) {
                    binding.layoutContent.userIconView.updateLayoutParams<LinearLayout.LayoutParams> {
                        height = dpToPx(56.0)
                        width = dpToPx(56.0)
                    }
                }
                binding.layoutContent.accentBackground.isGone = false
                binding.layoutContent.helloText.isGone = true
            }
            toggle = !toggle
        }
    }
}
