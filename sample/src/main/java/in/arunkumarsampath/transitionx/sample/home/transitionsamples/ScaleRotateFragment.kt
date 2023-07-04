package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.os.Bundle
import android.view.View
import androidx.core.view.animation.FastOutLinearInInterpolator
import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.R
import kotlinx.android.synthetic.main.layout_scale_rotate_content.*

class ScaleRotateFragment : BaseSampleFragment() {

    override val contentLayoutResource = R.layout.layout_scale_rotate_content
    override val titleRes = R.string.scale_rotate_transition

    private var toggle = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener {
            constraintLayout.prepareTransition {
                scaleRotate {
                    +arrowIconView
                    interpolator = FastOutLinearInInterpolator()
                }
            }

            with(arrowIconView) {
                if (toggle) {
                    scaleY = 2F
                    scaleX = 2F
                } else {
                    scaleY = 1F
                    scaleX = 1F
                }
                rotation += 90F
                toggle = !toggle
            }
        }
    }
}
