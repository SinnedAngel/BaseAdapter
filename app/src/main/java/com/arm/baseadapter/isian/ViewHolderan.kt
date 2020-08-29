package com.arm.baseadapter.isian

import android.view.ViewGroup
import com.arm.baseadapter.R
import com.arm.baseadapter.databinding.ItemOneBinding
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewHolder
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewParam
import com.tiket.android.commonsv2.widget.adapter.Listener.BaseViewHolderListener
import com.tiket.android.commonsv2.widget.adapter.Listener.ListenerInfo
import com.tiket.android.commonsv2.widget.adapter.Listener.ListenerInfoContainer

class ViewHolderan(viewGroup: ViewGroup) :
    BaseAdapterViewHolder<ItemOneBinding>(viewGroup, R.layout.item_one), ListenerInfoContainer {

    private val listenerInfo = ListenerInfo()

    init {
        binding?.root?.setOnClickListener {
            listenerInfo.onViewClickedListener?.onViewClicked(adapterPosition, it)
        }
    }

    override fun setListener(listener: BaseViewHolderListener) {
        if (listener is BaseViewHolderListener.OnViewClickedListener) {
            listenerInfo.onViewClickedListener = listener
        }
    }

    override fun refresh(paramAdapter: BaseAdapterViewParam) {
        if (paramAdapter is ViewParaman) {
            binding?.run {
                text1.text = paramAdapter.text1
                text2.text = paramAdapter.text2
            }
        }
    }
}