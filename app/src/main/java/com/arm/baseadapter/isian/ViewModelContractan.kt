package com.arm.baseadapter.isian

import androidx.lifecycle.MutableLiveData
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewParam

interface ViewModelContractan {
    val listData: MutableLiveData<MutableList<BaseAdapterViewParam>>
    fun getData()
}
