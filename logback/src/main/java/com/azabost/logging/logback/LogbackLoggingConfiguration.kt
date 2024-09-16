package com.azabost.logging.logback

import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.PatternLayout
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.Appender
import ch.qos.logback.core.util.StatusPrinter
import com.azabost.logging.logback.appenders.crashlytics.CrashlyticsAppender
import com.azabost.logging.logback.appenders.logcat.LogcatAppender
import org.slf4j.LoggerFactory

fun configureLogback() {
    val loggerContext = LoggerFactory.getILoggerFactory() as LoggerContext
    loggerContext.stop()

    val logcatAppender = createLogcatAppender(loggerContext)
    val crashlyticsAppender = createCrashlyticsAppender(loggerContext)

    val rootLogger = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME)

    rootLogger.addAppender(logcatAppender)
    rootLogger.addAppender(crashlyticsAppender)

    StatusPrinter.printIfErrorsOccured(loggerContext)
}

private fun createLogcatAppender(loggerContext: LoggerContext): Appender<ILoggingEvent> {
    val tagLayout = PatternLayout().apply {
        context = loggerContext
        pattern = "%logger{0}%nopex"
        start()
    }

    val messageLayout = PatternLayout().apply {
        context = loggerContext
        pattern = "[%thread] %msg%n"
        start()
    }
    return LogcatAppender(tagLayout = tagLayout, messageLayout = messageLayout).apply {
        context = loggerContext
        start()
    }
}

fun createCrashlyticsAppender(loggerContext: LoggerContext): Appender<ILoggingEvent> {
    val layout = PatternLayout().apply {
        context = loggerContext
        pattern = "[%level] [%logger{0}] [%thread] %msg%n"
        start()
    }
    return CrashlyticsAppender(layout = layout, logAllExceptions = true).apply {
        context = loggerContext
        start()
    }
}
