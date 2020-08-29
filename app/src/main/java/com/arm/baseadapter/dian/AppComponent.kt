package com.arm.baseadapter.dian

import com.arm.baseadapter.FirstFragment
import com.arm.baseadapter.MainActivity
import com.arm.baseadapter.SecondActivity
import dagger.Component

@Component(modules = [ActivityBuilder::class, Modulan::class, ModulanKedua::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: FirstFragment)
}