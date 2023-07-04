package `in`.arunkumarsampath.transitionx.sample.home.adapter.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import `in`.arunkumarsampath.transitionx.sample.databinding.LayoutHeaderItemTemplateBinding
import `in`.arunkumarsampath.transitionx.sample.home.adapter.SampleItem
import kotlinx.android.extensions.LayoutContainer

class HeaderItemDelegate : AbsListItemAdapterDelegate<SampleItem.HeaderItem, SampleItem, HeaderItemDelegate.HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): HeaderViewHolder {
        val binding = LayoutHeaderItemTemplateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderViewHolder(binding)
    }

    override fun isForViewType(item: SampleItem, items: MutableList<SampleItem>, position: Int): Boolean {
        return items[position] is SampleItem.HeaderItem
    }

    override fun onBindViewHolder(
        item: SampleItem.HeaderItem,
        viewHolder: HeaderViewHolder,
        payloads: MutableList<Any>,
    ) = viewHolder.bindHeader(item)

    class HeaderViewHolder(private val binding: LayoutHeaderItemTemplateBinding) : RecyclerView.ViewHolder(binding.root), LayoutContainer {

        override val containerView: View get() = binding.root

        fun bindHeader(headerItem: SampleItem.HeaderItem) {
            binding.headerName.setText(headerItem.stringRes)
        }
    }
}
