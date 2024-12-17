package com.example.testovyo

import android.app.Application
import com.example.testovyo.presentation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ApplicationApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ApplicationApp)
            modules(appModule)
        }
    }
}