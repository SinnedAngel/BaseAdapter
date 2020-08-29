package com.tiket.android.commonsv2.widget.adapter.Listener

import android.view.View

interface BaseViewHolderListener {
    interface OnViewClickedListener : BaseViewHolderListener {
        fun onViewClicked(position: Int, view: View)
    }
}