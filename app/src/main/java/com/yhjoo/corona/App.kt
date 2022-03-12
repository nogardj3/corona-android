package com.yhjoo.corona

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import java.io.IOException
import java.net.SocketException

class App : Application() {
    companion object {
        var appInstance: App? = null
            private set
        var isServerAlive = false
    }

    private var toast: Toast? = null

    @SuppressLint("ShowToast")
    override fun onCreate() {
        super.onCreate()

        Logger.addLogAdapter(AndroidLogAdapter())

        RxJavaPlugins.setErrorHandler { e: Throwable ->
            if (e is IOException || e is SocketException) {
                // fine, irrelevant network problem or API that throws on cancellation
                return@setErrorHandler
            }
            if (e is InterruptedException) {
                // fine, some blocking code was interrupted by a dispose call
                return@setErrorHandler
            }
            if (e is NullPointerException || e is IllegalArgumentException) {
                // that's likely a bug in the application Thread.currentThread().getUncaughtExceptionHandler() .uncaughtException(Thread.currentThread(), e);
                return@setErrorHandler
            }
            if (e is IllegalStateException) { // that's a bug in RxJava or in a custom operator
                Thread.currentThread().uncaughtExceptionHandler.uncaughtException(
                    Thread.currentThread(),
                    e
                )
                return@setErrorHandler
            }
            Log.e(
                "RxJava_HOOK",
                "Undeliverable exception received, not sure what to do" + e.message
            )
        }
        appInstance = this
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        toast = Toast.makeText(this, "Default", Toast.LENGTH_SHORT)
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }

            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        }
        )
    }

    fun showToast(text: String?) {
        toast!!.setText(text)
        toast!!.show()
    }
}