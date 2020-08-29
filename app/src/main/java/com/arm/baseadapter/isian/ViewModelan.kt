package com.arm.baseadapter.isian

import androidx.lifecycle.MutableLiveData
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewParam
import kotlin.random.Random

class ViewModelan : ViewModelContractan {
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
            val text = generateWord()
            result.add(ViewParaman(generateWord(), System.currentTimeMillis().toString()))
//            result.add(ViewParamanKedua((65 + i).toString(), i.toString()))
        }

        listData.value = result
    }

    private fun generateWord(): String {

        var result = ""

        rand?.let { rand ->
            val size = rand.nextInt(20)
            for (i in 0..size) {
                result += (65 + rand.nextInt(26)).toChar()
            }
        }

        return result
    }
}