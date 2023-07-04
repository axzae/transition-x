package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples.cart

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat.setTransitionName
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.navOptions
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.extensions.inflate
import `in`.arunkumarsampath.transitionx.sample.util.glide.GlideApp
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_cart_list_item_template.*
import java.util.*
import kotlin.collections.ArrayList

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        itemType: Int,
    ) = CartItemViewHolder.create(parent)

    override fun getItemCount() = CART_ITEMS.size

    override fun onBindViewHolder(
        holder: CartItemViewHolder,
        position: Int,
    ) = holder.bindCartItem(CART_ITEMS[position])

    class CartItemViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {
            with(containerView) {
                setOnClickListener {
                    if (adapterPosition != NO_POSITION) {
                        navigateToCartDetail()
                    }
                }
            }
        }

        private fun View.navigateToCartDetail() {
            val cartItem = CART_ITEMS[adapterPosition]
            setTransitionName(cartContentPreview, cartItem.cartImageTransitionName())
            setTransitionName(cartItemName, cartItem.name)
            setTransitionName(cartPrice, cartItem.price)
            findNavController().navigate(
                R.id.cartDetailFragment,
                CartDetailFragmentArgs
                    .Builder(cartItem)
                    .build()
                    .toBundle(),
                navOptions {
                },
                FragmentNavigator.Extras.Builder().run {
                    addSharedElement(cartItemName, cartItem.name)
                    addSharedElement(cartPrice, cartItem.price)
                    addSharedElement(cartContentPreview, cartItem.cartImageTransitionName())
                    build()
                },
            )
        }

        fun bindCartItem(cartItem: CartItem) {
            GlideApp.with(containerView).load(cartItem.drawableRes).into(cartContentPreview)
            cartItemName.text = cartItem.name
            cartPrice.text = cartItem.price
            cartItemStatus.text = cartItem.status
        }

        companion object {
            fun create(parent: ViewGroup) = CartItemViewHolder(parent.inflate(R.layout.layout_cart_list_item_template))
        }
    }

    companion object {
        private val random = Random()

        private val statuses = listOf(
            "In Stock",
            "Out of Stock",
            "Only ${random.nextInt(5) + 1} in stock",
        )
        private val items = listOf(
            "Pencil" to R.drawable.ic_pencil,
            "Tooth brush" to R.drawable.ic_tooth_brush,
            "Coffee Mug" to R.drawable.ic_cofee_mug,
        )

        private val CART_ITEMS: List<CartItem> by lazy {
            ArrayList<CartItem>().also { list ->
                repeat(10) {
                    val item = items[random.nextInt(items.size)]
                    list += CartItem(
                        item.second,
                        item.first,
                        statuses[random.nextInt(statuses.size)],
                        "$${random.nextInt(50)}.${random.nextInt(99)}",
                    )
                }
            }
        }
    }
}
