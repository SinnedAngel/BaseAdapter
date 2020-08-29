package com.arm.baseadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.arm.baseadapter.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        val fragment = FirstFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
    }
}