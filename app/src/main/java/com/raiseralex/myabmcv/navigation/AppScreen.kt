package com.raiseralex.myabmcv.navigation

import androidx.annotation.StringRes
import com.raiseralex.myabmcv.R

enum class AppScreen(@StringRes val title: Int) {
    WelcomeScreen(title = R.string.welcome_screen),
    VisitScreen(title = R.string.visit_screen),
    StartCVScreen(title = R.string.start_cv_screen),
}
