package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isGone
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.databinding.LayoutMaterialCardTransformationBinding
import `in`.arunkumarsampath.transitionx.transition.changetext.ChangeText

class MaterialCardTransformationFragment : BaseSampleFragment() {

    private lateinit var binding: LayoutMaterialCardTransformationBinding
    override val contentLayoutResource = R.layout.layout_material_card_transformation
    override val titleRes = R.string.metamorphosis

    private val requestManager by lazy { Glide.with(this) }

    private var expand = true

    private val collapseConstraint
        get() = ConstraintSet().apply {
            clone(requireContext(), R.layout.layout_material_card_transformation)
        }
    private val expandConstraint
        get() = ConstraintSet().apply {
            clone(requireContext(), R.layout.layout_material_card_transformation_expanded)
        }

    private val expandRunnable = { expandTransition() }
    private val collapseRunnable = { collapseTransition() }

    private val imageViews by lazy { arrayOf(binding.image1, binding.image2, binding.image3, binding.image4, binding.image5) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LayoutMaterialCardTransformationBinding.bind(viewStubRoot)
        setupViews()
    }

    private fun setupViews() {
        requestManager
            .load(R.drawable.ic_girl)
            .transition(withCrossFade())
            .apply(RequestOptions().circleCrop())
            .into(binding.avatar)
        listOf(
            R.drawable.ic_artic_1 to binding.image1,
            R.drawable.ic_artic_2 to binding.image2,
            R.drawable.ic_artic_3 to binding.image3,
            R.drawable.ic_artic_4 to binding.image4,
            R.drawable.ic_artic_5 to binding.image5,
        ).forEach { (drawable, image) ->
            requestManager.load(drawable)
                .transition(withCrossFade())
                .apply(RequestOptions().centerCrop())
                .into(image)
        }
        with(binding.collapseButton) {
            setOnClickListener {
                // removeCallbacks(expandRunnable, collapseRunnable)
                removeCallbacks(expandRunnable)
                val runnable = if (expand) expandRunnable else collapseRunnable
                postDelayed(runnable, 100) // Add delay to allow ripple animation to run
                expand = !expand
            }
        }
    }

    private fun collapseTransition() {
        binding.constraintLayout.prepareTransition {
            auto {
                ease { standardEasing }
                exclude(binding.metamorphosisDesc2)
            }
            transitionSet {
                fade()
                slide()
                ease { accelerateEasing }
                +binding.metamorphosisDesc2
            }
            changeImage { add(*imageViews) }
            onEnd {
                binding.constraintLayout.prepareTransition {
                    moveResize()
                    changeText {
                        +binding.collapseButton
                        changeTextBehavior = ChangeText.CHANGE_BEHAVIOR_OUT_IN
                    }
                }
                binding.collapseButton.setText(R.string.expand)
            }
            duration = 300
        }
        collapseConstraint.applyTo(binding.constraintLayout)
        binding.metamorphosisDesc2.isGone = true
        binding.metamorphosisDesc.isGone = false
    }

    private fun expandTransition() {
        binding.constraintLayout.prepareTransition {
            auto {
                ease { standardEasing }
                exclude(binding.metamorphosisDesc2)
            }
            transitionSet {
                fade()
                slide()
                ease { accelerateEasing }
                +binding.metamorphosisDesc2
            }
            changeImage { add(*imageViews) }
            onEnd {
                binding.constraintLayout.prepareTransition {
                    moveResize()
                    changeText {
                        +binding.collapseButton
                        changeTextBehavior = ChangeText.CHANGE_BEHAVIOR_OUT_IN
                    }
                }
                binding.collapseButton.setText(R.string.collapse)
            }
            duration = 300
        }
        expandConstraint.applyTo(binding.constraintLayout)
        binding.metamorphosisDesc2.isGone = false
        binding.metamorphosisDesc.isGone = true
    }
}
