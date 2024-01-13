package com.raiseralex.myabmcv.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers

@HiltAndroidApp
class MyCvApplication : Application() {
    companion object {
        // const val versionName = "v. ${BuildConfig.VERSION_NAME}/vc. ${BuildConfig.VERSION_CODE}"
        val dispatcherMain = Dispatchers.Main
        val dispatcherIO = Dispatchers.IO
    }
}
