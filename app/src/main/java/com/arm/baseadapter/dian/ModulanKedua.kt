package com.arm.baseadapter.dian

import com.arm.baseadapter.ViewHolderFactoryan
import com.arm.baseadapter.ViewHolderFactoryanKedua
import com.arm.baseadapter.isian.ViewModelContractan
import com.arm.baseadapter.isian.ViewModelan
import com.arm.baseadapter.isian.ViewModelanKedua
import com.tiket.android.commonsv2.widget.adapter.BaseAdapterViewHolderFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ModulanKedua {
    companion object {
        const val NAME_VIEW_MODEL = "modulanKeduaViewModel"
        const val NAME_FACTORY = "modulanKeduaFactory"
    }

    @Provides
    @Named(NAME_VIEW_MODEL)
    fun provideViewModel(): ViewModelContractan {
        return ViewModelanKedua()
    }

    @Provides
    @Named(NAME_FACTORY)
    fun provideViewHolderFactory(): BaseAdapterViewHolderFactory {
        return ViewHolderFactoryanKedua()
    }
}