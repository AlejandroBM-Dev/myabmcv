package com.raiseralex.myabmcv.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.raiseralex.myabmcv.ui.flows.homeFlow.views.MainScreen

fun NavGraphBuilder.onMainNavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    navigation(
        route = NestedScreen.MainFlow.name,
        startDestination = NestedScreen.MainScreen.name,
    ) {
        composable(route = NestedScreen.MainScreen.name) {
            MainScreen(
                modifier = modifier,
                onNextButton = {},
            )
        }
    }
}
