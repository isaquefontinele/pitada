package dev.pitada.app

import android.app.Application
import dev.pitada.shared.di.initKoin
import org.koin.android.ext.koin.androidContext

class PitadaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin { androidContext(this@PitadaApplication) }
    }
}
