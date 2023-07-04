package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples.cart

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartItem(
    @param:DrawableRes val drawableRes: Int,
    val name: String,
    val status: String,
    val price: String,
) : Parcelable {

    fun cartImageTransitionName() = "$status+$price+$name"
}
