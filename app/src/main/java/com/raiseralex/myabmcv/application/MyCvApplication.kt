package com.raiseralex.myabmcv.application

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.raiseralex.myabmcv.R
import com.raiseralex.myabmcv.ui.welcomeFlow.viewmodels.ThemeViewModel
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
