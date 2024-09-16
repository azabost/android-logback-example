package com.azabost.logging.mainscreen

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import org.slf4j.LoggerFactory

class MainActivity : ComponentActivity() {

    private val logger = LoggerFactory.getLogger(MainActivity::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logger.info("onCreate")

        findViewById<View>(R.id.logInfo).setOnClickListener {
            logger.info("Clicked")
        }

        findViewById<View>(R.id.logError).setOnClickListener {
            logger.error(
                "Clicked",
                IllegalArgumentException("Test exception", IllegalStateException("Test cause"))
            )
        }

        findViewById<View>(R.id.testCrash).setOnClickListener {
            throw IllegalArgumentException("Test exception", IllegalStateException("Test cause"))
        }
    }
}
