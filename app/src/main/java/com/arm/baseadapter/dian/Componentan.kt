package com.arm.baseadapter.dian

import com.arm.baseadapter.FirstFragment
import com.arm.baseadapter.MainActivity
import com.arm.baseadapter.SecondActivity
import dagger.Subcomponent

@Subcomponent
interface Componentan {

    @Subcomponent.Factory
    interface Factory {
        fun create(): Componentan
    }

    fun inject(activity: MainActivity)
    fun inject(activity: SecondActivity)
    fun inject(fragment: FirstFragment)
}