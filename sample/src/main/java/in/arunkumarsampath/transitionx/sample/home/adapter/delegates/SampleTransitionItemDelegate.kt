package `in`.arunkumarsampath.transitionx.sample.home.adapter.delegates

import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.extensions.inflate
import `in`.arunkumarsampath.transitionx.sample.home.adapter.SampleItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_sample_item_name_template.*

class SampleTransitionItemDelegate :
    AbsListItemAdapterDelegate<SampleItem.SampleTransitionItem, SampleItem, SampleTransitionItemDelegate.SamplesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup) = SampleTransitionItemDelegate.SamplesViewHolder.create(parent)

    override fun isForViewType(
        item: SampleItem,
        items: MutableList<SampleItem>,
        position: Int,
    ) = item is SampleItem.SampleTransitionItem

    override fun onBindViewHolder(
        item: SampleItem.SampleTransitionItem,
        viewHolder: SampleTransitionItemDelegate.SamplesViewHolder,
        payloads: MutableList<Any>,
    ) = viewHolder.bindSample(item)

    class SamplesViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindSample(sampleTransitionItem: SampleItem.SampleTransitionItem) {
            sampleName.setText(sampleTransitionItem.name)
            with(containerView) {
                setOnClickListener {
                    findNavController().navigate(
                        sampleTransitionItem.navigationId,
                        null,
                        DEFAULT_NAV_OPTIONS,
                    )
                }
            }
        }

        companion object {
            val DEFAULT_NAV_OPTIONS = navOptions {
                anim {
                    enter = R.anim.nav_default_enter_anim
                    exit = R.anim.nav_default_exit_anim
                    popEnter = R.anim.nav_default_pop_enter_anim
                    popExit = R.anim.nav_default_pop_exit_anim
                }
            }

            fun create(viewGroup: ViewGroup) = SamplesViewHolder(viewGroup.inflate(R.layout.layout_sample_item_name_template))
        }
    }
}
