package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.databinding.LayoutChangeColorContentBinding

class ChangeColorFragment : BaseSampleFragment() {

    private lateinit var binding: LayoutChangeColorContentBinding
    override val contentLayoutResource = R.layout.layout_change_color_content
    override val titleRes = R.string.change_color_transition

    private var toggle = true

    private val brownDrawable by lazy { ColorDrawable(ContextCompat.getColor(requireContext(), R.color.material_brown)) }
    private val whiteDrawable = ColorDrawable(Color.WHITE)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LayoutChangeColorContentBinding.bind(viewStubRoot)
        setupHeaderImage()
        initClickListeners()
    }

    private fun setupHeaderImage() {
        Glide.with(binding.imageView)
            .load(R.drawable.ic_dog_cute)
            .transition(withCrossFade())
            .into(binding.imageView)
    }

    private fun initClickListeners() {
        binding.fab.setOnClickListener {
            binding.frameLayout.prepareTransition {
                +binding.textView
                changeColor()
                duration = 1000
            }
            with(binding.textView) {
                if (toggle) {
                    background = brownDrawable
                    setTextColor(Color.WHITE)
                } else {
                    background = whiteDrawable
                    setTextColor(Color.BLACK)
                }
            }
            toggle = !toggle
        }
    }
}
