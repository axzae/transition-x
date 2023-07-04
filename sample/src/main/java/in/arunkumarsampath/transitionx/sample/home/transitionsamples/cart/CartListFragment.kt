package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples.cart

import android.os.Bundle
import android.view.View
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.databinding.LayoutContentCartListBinding
import `in`.arunkumarsampath.transitionx.sample.home.transitionsamples.BaseSampleFragment
import timber.log.Timber

class CartListFragment : BaseSampleFragment() {

    private lateinit var binding: LayoutContentCartListBinding
    override val contentLayoutResource = R.layout.layout_content_cart_list
    override val titleRes = R.string.cart

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LayoutContentCartListBinding.bind(viewStubRoot)
        setupCartList()
    }

    private fun setupCartList() {
        binding.cartList.adapter = CartAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("onDestroyView")
    }
}
