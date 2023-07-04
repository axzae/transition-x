package `in`.arunkumarsampath.transitionx.sample.home.adapter.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import `in`.arunkumarsampath.transitionx.sample.databinding.LayoutSampleItemNameTemplateBinding
import `in`.arunkumarsampath.transitionx.sample.home.adapter.SampleItem
import kotlinx.android.extensions.LayoutContainer

class SampleTransitionItemDelegate :
    AbsListItemAdapterDelegate<SampleItem.SampleTransitionItem, SampleItem, SampleTransitionItemDelegate.SamplesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): SamplesViewHolder {
        val binding = LayoutSampleItemNameTemplateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SamplesViewHolder(binding)
    }

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

    class SamplesViewHolder(private val binding: LayoutSampleItemNameTemplateBinding) : RecyclerView.ViewHolder(binding.root), LayoutContainer {
        override val containerView: View get() = binding.root

        fun bindSample(sampleTransitionItem: SampleItem.SampleTransitionItem) {
            binding.sampleName.setText(sampleTransitionItem.name)
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
                    enter = androidx.navigation.ui.R.anim.nav_default_enter_anim
                    exit = androidx.navigation.ui.R.anim.nav_default_exit_anim
                    popEnter = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim
                    popExit = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim
                }
            }
        }
    }
}
