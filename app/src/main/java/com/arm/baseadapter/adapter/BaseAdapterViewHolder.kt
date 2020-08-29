package com.tiket.android.commonsv2.widget.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapterViewHolder<T : ViewDataBinding>(val view: View) :
        RecyclerView.ViewHolder(view) {

    constructor(view: ViewGroup, @LayoutRes resId: Int) :
            this(DataBindingUtil.inflate<T>(LayoutInflater.from(view.context), resId, view, false).root)

    var binding: T? = DataBindingUtil.getBinding(view)
    abstract fun refresh(paramAdapter: BaseAdapterViewParam)
}