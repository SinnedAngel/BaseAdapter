package com.tiket.android.commonsv2.widget.adapter

import android.view.ViewGroup

interface BaseAdapterViewHolderFactory {
    fun createViewHolder(viewType: Int, viewGroup: ViewGroup): BaseAdapterViewHolder<*>
}