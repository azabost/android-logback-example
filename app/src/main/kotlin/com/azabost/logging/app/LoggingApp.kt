package com.azabost.logging.app

import android.app.Application
import com.azabost.logging.logback.configureLogback


class LoggingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        configureLogback()
    }
}