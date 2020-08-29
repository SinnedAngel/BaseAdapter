package com.tiket.android.commonsv2.widget.adapter.Listener

import android.view.View
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewParam

interface BaseAdapterListener {
    interface OnItemClickedListener : BaseAdapterListener {
        fun onItemClicked(viewParam: BaseAdapterViewParam, view: View)
    }
}