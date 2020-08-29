package com.tiket.android.commonsv2.widget.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tiket.android.commonsv2.widget.adapter.Listener.BaseAdapterListener
import com.tiket.android.commonsv2.widget.adapter.Listener.BaseViewHolderListener
import com.tiket.android.commonsv2.widget.adapter.Listener.ListenerInfoContainer

abstract class BaseAdapter(val viewHolderFactory: BaseAdapterViewHolderFactory) : RecyclerView.Adapter<BaseAdapterViewHolder<*>>(),
        BaseViewHolderListener.OnViewClickedListener {
    var items = listOf<BaseAdapterViewParam>()

    var listener: BaseAdapterListener? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        recyclerView.context?.let {
            if (it is BaseAdapterListener)
                listener = it
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseAdapterViewHolder<*> {
        val viewHolder = viewHolderFactory.createViewHolder(viewType, parent)

        if (viewHolder is ListenerInfoContainer) setupListener(viewHolder)

        return viewHolder
    }

    override fun getItemViewType(position: Int): Int {
        if (items.size > position)
            return items[position].getViewType()
        return super.getItemViewType(position)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseAdapterViewHolder<*>, position: Int) {
        if (items.size > position) holder.refresh(items[position])
    }

    open fun setupListener(container: ListenerInfoContainer) {
        container.setListener(this)
    }

    override fun onViewClicked(position: Int, view: View) {
        listener?.let {
            if (it is BaseAdapterListener.OnItemClickedListener) {
                if (items.size > position) it.onItemClicked(items[position], view)
            }
        }
    }
}