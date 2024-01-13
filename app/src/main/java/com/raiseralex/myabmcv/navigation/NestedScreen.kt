package com.raiseralex.myabmcv.navigation

import androidx.annotation.StringRes
import com.raiseralex.myabmcv.R

enum class NestedScreen(@StringRes val title: Int) {
    RootFlow(title = R.string.root_nav_host),

    // WELCOME FLOW
    WelcomeFlow(title = R.string.welcome_flow),
    WelcomeScreen(title = R.string.welcome_screen),
    VisitScreen(title = R.string.visit_screen),
    StartCVScreen(title = R.string.start_cv_screen),

    // MAIN FLOW
    MainFlow(title = R.string.main_flow),
    MainScreen(title = R.string.main_screen),
}
