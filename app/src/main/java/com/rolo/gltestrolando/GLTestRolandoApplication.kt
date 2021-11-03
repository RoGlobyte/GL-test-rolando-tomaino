package com.rolo.gltestrolando

import android.app.Application
import com.rolo.gltestrolando.module.appModule
import com.rolo.gltestrolando.module.repoModule
import com.rolo.gltestrolando.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GLTestRolandoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GLTestRolandoApplication)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }

}