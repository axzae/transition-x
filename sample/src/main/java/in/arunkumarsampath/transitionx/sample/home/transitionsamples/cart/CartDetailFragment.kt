package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples.cart

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import `in`.arunkumarsampath.transitionx.sample.databinding.FragmentCartDetailContentBinding
import `in`.arunkumarsampath.transitionx.sample.utils.GlideApp
import `in`.arunkumarsampath.transitionx.transitionSet

class CartDetailFragment : Fragment() {

    private lateinit var binding: FragmentCartDetailContentBinding
    private val cartItem by lazy { CartDetailFragmentArgs.fromBundle(requireArguments()).cartItem }

    private fun applyTransition() {
        sharedElementEnterTransition = transitionSet {
            transitionSet {
                changeImage()
                moveResize()
                changeClipBounds()
                scaleRotate()
                ease {
                    standardEasing
                }
                duration = 375
                +cartItem.cartImageTransitionName()
            }
            transitionSet {
                ease {
                    standardEasing
                }
                moveResize()
                scaleRotate()
                add(cartItem.name, cartItem.price)
                duration = 375
            }
        }
        enterTransition = transitionSet {
            slide()
            fade()
            ease {
                decelerateEasing
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCartDetailContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        applyTransition()
        setupViews()
    }

    private fun setupViews() {
        ViewCompat.setTransitionName(
            binding.cartContentPreview,
            cartItem.cartImageTransitionName(),
        )

        with(binding.cartItemName) {
            text = cartItem.name
            ViewCompat.setTransitionName(this, cartItem.name)
        }

        with(binding.cartItemPrice) {
            text = cartItem.price
            ViewCompat.setTransitionName(this, cartItem.price)
        }
        loadCartImage()
    }

    private fun loadCartImage() {
        GlideApp.with(this)
            .load(cartItem.drawableRes)
            .listener(
                object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        startPostponedEnterTransition()
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        startPostponedEnterTransition()
                        return false
                    }
                },
            ).into(binding.cartContentPreview)
    }
}
