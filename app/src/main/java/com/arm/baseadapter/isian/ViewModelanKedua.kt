package com.arm.baseadapter.isian

import androidx.lifecycle.MutableLiveData
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewParam
import kotlin.random.Random

class ViewModelanKedua : ViewModelContractan {
    override val listData = MutableLiveData<MutableList<BaseAdapterViewParam>>()

    var rand: Random? = null
        get() {
            if (field == null) {
                field = Random(System.currentTimeMillis())
            }
            return field
        }

    override fun getData() {
        val result = mutableListOf<BaseAdapterViewParam>()
        val size = rand?.nextInt(100) ?: 20
        for (i in 0..size) {
            val text = (65 + i % 26).toChar()
            result.add(ViewParaman(i.toString(), text.toString()))
        }

        listData.value = result
    }
}