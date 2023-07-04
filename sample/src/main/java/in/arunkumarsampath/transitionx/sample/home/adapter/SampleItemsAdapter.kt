package `in`.arunkumarsampath.transitionx.sample.home.adapter

import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.home.adapter.delegates.HeaderItemDelegate
import `in`.arunkumarsampath.transitionx.sample.home.adapter.delegates.SampleTransitionItemDelegate

class SampleItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val delegatesManager = AdapterDelegatesManager<List<SampleItem>>().apply {
        addDelegate(SampleTransitionItemDelegate())
        addDelegate(HeaderItemDelegate())
    }

    private val sampleItems = listOf(
        header(R.string.simple_transitions),
        sample(R.id.snackBarFragment, R.string.sample_snackbar_fab_transition),
        sample(R.id.cascadeTransitionFragment, R.string.sample_cascade_transition),
        sample(R.id.customTransitionFragment, R.string.sample_custom_transition),
        sample(R.id.scaleRotateFragment, R.string.scale_rotate_transition),
        sample(R.id.arcMotionFragment, R.string.arc_motion_transition),
        sample(R.id.changeImageTransformFragment, R.string.change_image_transition),
        sample(R.id.changeColorFragment, R.string.change_color_transition),
        sample(R.id.changeTextTransitionFragment, R.string.change_text_transition),
        header(R.string.advanced_transitions),
        sample(R.id.materialCardTransformationFragment, R.string.material_card_transformation),
        sample(R.id.animatedBottomNavigationFragment, R.string.animated_bottom_navigation_fragment),
        header(R.string.shared_element_transition),
        sample(R.id.cartListFragment, R.string.cart_list),
    )

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(sampleItems, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, itemType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, itemType)
    }

    override fun getItemCount() = sampleItems.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegatesManager.onBindViewHolder(sampleItems, position, holder)
    }

    companion object {
        fun sample(
            @IdRes navigationId: Int,
            @StringRes name: Int,
        ) = SampleItem.SampleTransitionItem(navigationId, name)

        fun header(@StringRes headerName: Int) = SampleItem.HeaderItem(headerName)
    }
}
