package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.graphics.Color.BLACK
import android.graphics.Color.BLUE
import android.graphics.Color.CYAN
import android.graphics.Color.DKGRAY
import android.graphics.Color.GRAY
import android.graphics.Color.GREEN
import android.graphics.Color.LTGRAY
import android.graphics.Color.MAGENTA
import android.graphics.Color.RED
import android.graphics.Color.WHITE
import android.graphics.Color.YELLOW
import android.graphics.Color.blue
import android.graphics.Color.green
import android.graphics.Color.red
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.databinding.LayoutCustomTransitionContentBinding
import `in`.arunkumarsampath.transitionx.sample.transition.color.changecardcolor.ChangeCardColor

class CustomTransitionFragment : BaseSampleFragment() {

    private lateinit var binding: LayoutCustomTransitionContentBinding
    override val contentLayoutResource = R.layout.layout_custom_transition_content
    override val titleRes = R.string.sample_custom_transition

    private val colors = listOf(
        BLACK,
        DKGRAY,
        GRAY,
        LTGRAY,
        WHITE,
        RED,
        GREEN,
        BLUE,
        YELLOW,
        CYAN,
        MAGENTA,
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LayoutCustomTransitionContentBinding.bind(viewStubRoot)
        binding.fab.setOnClickListener {
            val color = colors.shuffled().first()

            binding.constraintLayout.prepareTransition {
                customTransition<ChangeCardColor> {
                    +binding.colorChangeCardView
                }
                changeColor {
                    +binding.colorChangeTextView
                }
                duration = 1000
            }

            binding.colorChangeCardView.setCardBackgroundColor(color)
            binding.colorChangeTextView.setTextColor(calcForegroundWhiteOrBlack(color))
        }
    }

    companion object {
        private const val CONTRAST_LIGHT_ITEM_THRESHOLD = 3f

        /**
         * Calculates the contrast between the given color and white, using the algorithm provided by
         * the WCAG v2 in http://www.w3.org/TR/WCAG20/#contrast-ratiodef.
         *
         *
         * {@see https://chromium.googlesource.com/chromium/src/+/66.0.3335.4/chrome/android/java/src/org/chromium/chrome/browser/util/ColorUtils.java}
         */
        private fun getContrastForColor(color: Int): Float {
            var bgR = red(color) / 255f
            var bgG = green(color) / 255f
            var bgB = blue(color) / 255f
            bgR = if (bgR < 0.03928f) bgR / 12.92f else Math.pow(((bgR + 0.055f) / 1.055f).toDouble(), 2.4).toFloat()
            bgG = if (bgG < 0.03928f) bgG / 12.92f else Math.pow(((bgG + 0.055f) / 1.055f).toDouble(), 2.4).toFloat()
            bgB = if (bgB < 0.03928f) bgB / 12.92f else Math.pow(((bgB + 0.055f) / 1.055f).toDouble(), 2.4).toFloat()
            val bgL = 0.2126f * bgR + 0.7152f * bgG + 0.0722f * bgB
            return Math.abs(1.05f / (bgL + 0.05f))
        }

        /**
         * Check whether lighter or darker foreground elements (i.e. text, drawables etc.)
         * should be used depending on the given background color.
         *
         * @param backgroundColor The background color value which is being queried.
         * @return Whether light colored elements should be used.
         */
        private fun shouldUseLightForegroundOnBackground(backgroundColor: Int): Boolean {
            return getContrastForColor(backgroundColor) >= CONTRAST_LIGHT_ITEM_THRESHOLD
        }

        /**
         * Returns white or black based on color luminance
         *
         * @param backgroundColor the color to get foreground for
         * @return White for darker colors and black for ligher colors
         */
        @ColorInt
        fun calcForegroundWhiteOrBlack(@ColorInt backgroundColor: Int): Int {
            return if (shouldUseLightForegroundOnBackground(backgroundColor)) {
                WHITE
            } else {
                BLACK
            }
        }
    }
}
