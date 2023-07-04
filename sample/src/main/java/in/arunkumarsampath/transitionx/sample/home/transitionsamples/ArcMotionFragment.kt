package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.updateLayoutParams
import androidx.transition.ArcMotion
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.extensions.dpToPx
import kotlinx.android.synthetic.main.layout_arc_motion_content.*

class ArcMotionFragment : BaseSampleFragment() {

    override val contentLayoutResource = R.layout.layout_arc_motion_content
    override val titleRes = R.string.arc_motion_transition

    private var toggle = true

    @SuppressLint("RtlHardcoded")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMeow()
        initClickListeners()
    }

    private fun setupMeow() {
        Glide.with(userIconView)
            .load(R.drawable.cute_cat)
            .apply(RequestOptions().circleCrop())
            .into(userIconView)
    }

    private fun initClickListeners() {
        fab.setOnClickListener {
            frameLayout.prepareTransition {
                moveResize {
                    pathMotion = ArcMotion()
                    +userIconView
                }
            }

            with(userIconView) {
                if (toggle) {
                    updateLayoutParams<FrameLayout.LayoutParams> {
                        height = context.dpToPx(112.0)
                        width = context.dpToPx(112.0)
                        gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
                    }
                } else {
                    updateLayoutParams<FrameLayout.LayoutParams> {
                        height = context.dpToPx(56.0)
                        width = context.dpToPx(56.0)
                        gravity = Gravity.START or Gravity.LEFT or Gravity.CENTER_VERTICAL
                    }
                }
                toggle = !toggle
            }
        }
    }
}
