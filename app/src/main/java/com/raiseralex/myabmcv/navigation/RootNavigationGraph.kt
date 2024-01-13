package com.raiseralex.myabmcv.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@ExperimentalMaterial3Api
@Composable
fun RootNavigationGraph(navHostController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navHostController,
        modifier = modifier,
        route = NestedScreen.RootFlow.name,
        startDestination = NestedScreen.WelcomeFlow.name,
    ) {
        onWelcomeNavGraph(navController = navHostController)
        onMainNavigationGraph(navController = navHostController)
    }
}
