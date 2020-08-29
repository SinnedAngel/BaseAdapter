package com.arm.baseadapter

import android.view.ViewGroup
import com.arm.baseadapter.isian.ViewHolderan
import com.arm.baseadapter.isian.ViewHolderanKedua
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewHolder
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewHolderFactory

class ViewHolderFactoryan : BaseAdapterViewHolderFactory {
    override fun createViewHolder(viewType: Int, viewGroup: ViewGroup): BaseAdapterViewHolder<*> {
        return when (viewType) {
            0 -> ViewHolderan(viewGroup)
            else -> ViewHolderanKedua(viewGroup)
        }
    }
}