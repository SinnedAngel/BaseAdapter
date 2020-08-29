package com.arm.baseadapter.dian

import com.arm.baseadapter.MainActivity
import com.arm.baseadapter.SecondActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    companion object{
        const val MainActivityViewModel = Modulan.NAME_VIEW_MODEL
        const val MainActivityFactory = Modulan.NAME_FACTORY

        const val SecondActivityViewModel = ModulanKedua.NAME_VIEW_MODEL
        const val SecondActivityFactory = ModulanKedua.NAME_FACTORY
    }

    @ContributesAndroidInjector(modules = [Modulan::class])
    abstract fun bindMainActiity(): MainActivity

}