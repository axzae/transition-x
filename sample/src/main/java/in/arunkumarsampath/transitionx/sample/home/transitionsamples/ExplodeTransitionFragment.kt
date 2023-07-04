package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.app.Fragment
import androidx.core.view.isGone
import androidx.core.view.updateLayoutParams
import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.extensions.dpToPx
import kotlinx.android.synthetic.main.layout_explode_transition_content.*

class ExplodeTransitionFragment : Fragment() {

    private var toggle = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = inflater.inflate(R.layout.fragment_explode_transition, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewListeners()
    }

    private fun initViewListeners() {
        fab.setOnClickListener {
            frameLayout.prepareTransition {
                explode {
                    +accentBackground
                }
                moveResize {
                    +userIconView
                }
            }

            if (toggle) {
                with(requireContext()) {
                    userIconView.updateLayoutParams<LinearLayout.LayoutParams> {
                        height = dpToPx(112.0)
                        width = dpToPx(112.0)
                    }
                }
                accentBackground.isGone = true
                helloText.isGone = false
            } else {
                with(requireContext()) {
                    userIconView.updateLayoutParams<LinearLayout.LayoutParams> {
                        height = dpToPx(56.0)
                        width = dpToPx(56.0)
                    }
                }
                accentBackground.isGone = false
                helloText.isGone = true
            }
            toggle = !toggle
        }
    }
}
