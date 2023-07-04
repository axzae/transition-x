package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples.cart

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Fragment
import androidx.core.view.ViewCompat
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.util.glide.GlideApp
import `in`.arunkumarsampath.transitionx.transitionSet
import kotlinx.android.synthetic.main.fragment_cart_detail_content.*

class CartDetailFragment : Fragment() {

    private val cartItem by lazy { CartDetailFragmentArgs.fromBundle(arguments!!).cartItem }

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflater.inflate(R.layout.fragment_cart_detail_content, container, false)!!

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
            cartContentPreview,
            cartItem.cartImageTransitionName(),
        )

        with(cartItemName) {
            text = cartItem.name
            ViewCompat.setTransitionName(this, cartItem.name)
        }

        with(cartItemPrice) {
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
            ).into(cartContentPreview)
    }
}
