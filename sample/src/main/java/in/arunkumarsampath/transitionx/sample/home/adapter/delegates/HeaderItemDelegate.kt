package `in`.arunkumarsampath.transitionx.sample.home.adapter.delegates

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.extensions.inflate
import `in`.arunkumarsampath.transitionx.sample.home.adapter.SampleItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_header_item_template.*

class HeaderItemDelegate : AbsListItemAdapterDelegate<SampleItem.HeaderItem, SampleItem, HeaderItemDelegate.HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup) = HeaderViewHolder.create(parent)

    override fun isForViewType(item: SampleItem, items: MutableList<SampleItem>, position: Int): Boolean {
        return items[position] is SampleItem.HeaderItem
    }

    override fun onBindViewHolder(
        item: SampleItem.HeaderItem,
        viewHolder: HeaderViewHolder,
        payloads: MutableList<Any>,
    ) = viewHolder.bindHeader(item)

    class HeaderViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindHeader(headerItem: SampleItem.HeaderItem) {
            headerName.setText(headerItem.stringRes)
        }

        companion object {
            fun create(viewGroup: ViewGroup) = HeaderViewHolder(viewGroup.inflate(R.layout.layout_header_item_template))
        }
    }
}
