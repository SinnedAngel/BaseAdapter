package com.arm.baseadapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arm.baseadapter.databinding.FragmentFirstBinding
import com.arm.baseadapter.dian.ActivityBuilder
import com.arm.baseadapter.isian.ViewModelContractan
import com.arm.baseadapter.isian.ViewParaman
import com.tiket.android.commonsv2.widget.adapter.BaseAdapter
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewHolderFactory
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewParam
import com.tiket.android.commonsv2.widget.adapter.Listener.BaseAdapterListener
import javax.inject.Inject
import javax.inject.Named

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), BaseAdapterListener.OnItemClickedListener {

    private val observer = Observer<MutableList<BaseAdapterViewParam>> { list ->
        binding.rvList.adapter?.let { adapter ->
            if (adapter is BaseAdapter) {
                adapter.items = list
            }

            adapter.notifyDataSetChanged()
        }
    }

    @field:[Inject Named(ActivityBuilder.SecondActivityViewModel)]
    lateinit var viewModelContractan: ViewModelContractan

    @field:[Inject Named(ActivityBuilder.SecondActivityFactory)]
    lateinit var adapterFactory: BaseAdapterViewHolderFactory

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_first, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.rvList) {
            adapter = object : BaseAdapter(adapterFactory) {
                override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
                    super.onAttachedToRecyclerView(recyclerView)
                    listener = this@FirstFragment
                }
            }
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        with(viewModelContractan.listData) {
            removeObserver(observer)
            activity?.let {
                observe(it, observer)
            }
        }

        viewModelContractan.getData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as MainApplication).component.inject(this)
    }

    override fun onItemClicked(viewParam: BaseAdapterViewParam, view: View) {
        if (viewParam is ViewParaman) {
            Toast.makeText(context, "${viewParam.text1} : ${viewParam.text2}", Toast.LENGTH_LONG)
                .show()
        }
    }
}
