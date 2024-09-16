package com.azabost.logging.logback.appenders.logcat

import android.util.Log
import ch.qos.logback.classic.Level
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.Layout
import ch.qos.logback.core.UnsynchronizedAppenderBase

class LogcatAppender(
    private val messageLayout: Layout<ILoggingEvent>,
    private val tagLayout: Layout<ILoggingEvent>,
) : UnsynchronizedAppenderBase<ILoggingEvent>() {

    public override fun append(eventObject: ILoggingEvent) {
        val logcatLevel = eventObject.level.toLogcatLevel() ?: return

        val tag = tagLayout.doLayout(eventObject)
        val message = messageLayout.doLayout(eventObject)

        // Note: you may want to put Log.println behind an interface to make this class testable
        Log.println(logcatLevel, tag, message)
    }
}

internal fun Level.toLogcatLevel() =
    when (levelInt) {
        Level.ALL_INT, Level.TRACE_INT -> Log.VERBOSE
        Level.DEBUG_INT -> Log.DEBUG
        Level.INFO_INT -> Log.INFO
        Level.WARN_INT -> Log.WARN
        Level.ERROR_INT -> Log.ERROR
        Level.OFF_INT -> null
        else -> null
    }
