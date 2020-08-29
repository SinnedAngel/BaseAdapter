package com.arm.baseadapter

import android.view.ViewGroup
import com.arm.baseadapter.isian.ViewHolderan
import com.arm.baseadapter.isian.ViewHolderanKedua
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewHolder
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewHolderFactory

class ViewHolderFactoryanKedua : BaseAdapterViewHolderFactory {
    override fun createViewHolder(viewType: Int, viewGroup: ViewGroup): BaseAdapterViewHolder<*> {
        return ViewHolderanKedua(viewGroup)
    }
}