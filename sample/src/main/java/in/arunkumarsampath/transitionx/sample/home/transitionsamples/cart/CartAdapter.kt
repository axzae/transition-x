package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat.setTransitionName
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.navOptions
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.databinding.LayoutCartListItemTemplateBinding
import `in`.arunkumarsampath.transitionx.sample.utils.GlideApp
import kotlinx.android.extensions.LayoutContainer
import java.util.Random

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        itemType: Int,
    ): CartItemViewHolder {
        val binding = LayoutCartListItemTemplateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartItemViewHolder(binding)
    }

    override fun getItemCount() = CART_ITEMS.size

    override fun onBindViewHolder(
        holder: CartItemViewHolder,
        position: Int,
    ) = holder.bindCartItem(CART_ITEMS[position])

    class CartItemViewHolder(private val binding: LayoutCartListItemTemplateBinding) : RecyclerView.ViewHolder(binding.root), LayoutContainer {

        override val containerView: View get() = binding.root

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
            setTransitionName(binding.cartContentPreview, cartItem.cartImageTransitionName())
            setTransitionName(binding.cartItemName, cartItem.name)
            setTransitionName(binding.cartPrice, cartItem.price)
            findNavController().navigate(
                R.id.cartDetailFragment,
                CartDetailFragmentArgs(cartItem).toBundle(),
                navOptions {
                },
                FragmentNavigator.Extras.Builder().run {
                    addSharedElement(binding.cartItemName, cartItem.name)
                    addSharedElement(binding.cartPrice, cartItem.price)
                    addSharedElement(binding.cartContentPreview, cartItem.cartImageTransitionName())
                    build()
                },
            )
        }

        fun bindCartItem(cartItem: CartItem) {
            GlideApp.with(containerView).load(cartItem.drawableRes).into(binding.cartContentPreview)
            binding.cartItemName.text = cartItem.name
            binding.cartPrice.text = cartItem.price
            binding.cartItemStatus.text = cartItem.status
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
