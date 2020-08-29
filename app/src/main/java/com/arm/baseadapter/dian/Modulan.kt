package com.arm.baseadapter.dian

import com.arm.baseadapter.ViewHolderFactoryan
import com.arm.baseadapter.isian.ViewModelContractan
import com.arm.baseadapter.isian.ViewModelan
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewHolderFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class Modulan {
    companion object{
        const val NAME_VIEW_MODEL = "modulanViewModel"
        const val NAME_FACTORY = "modulanFactory"
    }

    @Provides
    @Named(NAME_VIEW_MODEL)
    fun provideViewModel(): ViewModelContractan {
        return ViewModelan()
    }

    @Provides
    @Named(NAME_FACTORY)
    fun provideViewHolderFactory(): BaseAdapterViewHolderFactory {
        return ViewHolderFactoryan()
    }
}