package com.raiseralex.myabmcv.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raiseralex.myabmcv.ui.flows.homeFlow.views.MainScreen

@ExperimentalMaterial3Api
@Composable
fun RootNavigationGraph(navHostController: NavHostController, modifier: Modifier) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        route = NestedScreen.RootFlow.name,
        startDestination = NestedScreen.WelcomeFlow.name,
    ) {
        onWelcomeNavGraph(navController = navHostController, modifier = modifier)
        composable(route = NestedScreen.MainFlow.name) {
            MainScreen()
        }
    }
}
