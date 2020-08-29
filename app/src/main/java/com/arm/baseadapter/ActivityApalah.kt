package com.arm.baseadapter

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arm.baseadapter.databinding.FragmentFirstBinding
import com.arm.baseadapter.databinding.ItemOneBinding
import com.arm.baseadapter.isian.ViewParaman
import com.tiket.android.commonsv2.widget.adapter.BaseAdapter
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewHolder
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewHolderFactory
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewParam

class ActivityApalah : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapterX = object : BaseAdapter(object : BaseAdapterViewHolderFactory {
            override fun createViewHolder(
                viewType: Int,
                viewGroup: ViewGroup
            ): BaseAdapterViewHolder<*> {
                return object :
                    BaseAdapterViewHolder<ItemOneBinding>(
                        viewGroup,
                        R.layout.item_one
                    ) {
                    override fun refresh(paramAdapter: BaseAdapterViewParam) {
                        if (paramAdapter is ViewParaman) {
                            binding?.text1?.text = paramAdapter.text1
                            binding?.text2?.text = paramAdapter.text2
                        }
                    }
                }
            }
        }) {}

        val binding =
            DataBindingUtil.setContentView<FragmentFirstBinding>(this, R.layout.fragment_first)
        with(binding.rvList) {
            this.adapter = adapterX
            layoutManager = LinearLayoutManager(this@ActivityApalah, RecyclerView.VERTICAL, false)
        }


        val items = mutableListOf<ViewParaman>().apply {
            add(ViewParaman("1", "1"))
            add(ViewParaman("2", "2"))
        }

        adapterX.items = items
        adapterX.notifyDataSetChanged()
    }
}