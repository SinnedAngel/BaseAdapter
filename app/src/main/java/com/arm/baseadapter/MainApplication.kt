package com.arm.baseadapter

import android.app.Application
import com.arm.baseadapter.dian.DaggerAppComponent

class MainApplication : Application() {
    val component = DaggerAppComponent.create()
}