package com.arm.baseadapter

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.arm.baseadapter.databinding.FragmentFirstBinding
import com.arm.baseadapter.dian.ActivityBuilder
import com.arm.baseadapter.dian.ModuleBinding
import com.arm.baseadapter.isian.ViewModelContractan
import com.tiket.android.commonsv2.widget.adapter.BaseAdapter
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewHolderFactory
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewParam
import com.tiket.android.commonsv2.widget.adapter.Listener.BaseAdapterListener

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity(), BaseAdapterListener.OnItemClickedListener {

    private val observer = Observer<MutableList<BaseAdapterViewParam>> { list ->
        binding.rvList.adapter?.let { adapter ->
            if (adapter is BaseAdapter) {
                adapter.items = list
            }

            adapter.notifyDataSetChanged()
        }
    }

    @field:[Inject Named(ActivityBuilder.MainActivityViewModel)]
    lateinit var viewModelContractan: ViewModelContractan

    @field:[Inject Named(ActivityBuilder.MainActivityFactory)]
    lateinit var adapterFactory: BaseAdapterViewHolderFactory

    lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MainApplication).component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_first)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_first)
        binding.setVariable(0, viewModelContractan)
        binding.executePendingBindings()
        setSupportActionBar(toolbar)

        with(binding.rvList) {
            adapter = object : BaseAdapter(adapterFactory) {}
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

        with(viewModelContractan.listData) {
            removeObserver(observer)
            observe(this@MainActivity, observer)
        }

        viewModelContractan.getData()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onItemClicked(viewParam: BaseAdapterViewParam, view: View) {
        startActivity(Intent(this, SecondActivity::class.java))
    }
}
