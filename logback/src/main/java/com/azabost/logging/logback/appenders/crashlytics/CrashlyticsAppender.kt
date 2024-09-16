package com.azabost.logging.logback.appenders.crashlytics

import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.classic.spi.ThrowableProxy
import ch.qos.logback.core.AppenderBase
import ch.qos.logback.core.Layout
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

class CrashlyticsAppender(
    private val layout: Layout<ILoggingEvent>,
    private val logAllExceptions: Boolean,
) : AppenderBase<ILoggingEvent>() {

    override fun append(eventObject: ILoggingEvent) {
        // Note: you may want to put Firebase.crashlytics.log behind an interface to make this class testable
        Firebase.crashlytics.log(layout.doLayout(eventObject))
        recordExceptionIfRequested(eventObject)
    }

    private fun recordExceptionIfRequested(eventObject: ILoggingEvent) {
        val throwable = (eventObject.throwableProxy as? ThrowableProxy)?.throwable

        if (logAllExceptions && throwable != null) {
            Firebase.crashlytics.recordException(throwable)
        }
    }
}