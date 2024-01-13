package com.raiseralex.myabmcv.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.raiseralex.myabmcv.ui.flows.welcomeFlow.views.StartCV
import com.raiseralex.myabmcv.ui.flows.welcomeFlow.views.VisitCompose
import com.raiseralex.myabmcv.ui.flows.welcomeFlow.views.WelcomeCompose

fun NavGraphBuilder.onWelcomeNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    navigation(
        route = NestedScreen.WelcomeFlow.name,
        startDestination = NestedScreen.WelcomeScreen.name,
    ) {
        composable(route = NestedScreen.WelcomeScreen.name) {
            WelcomeCompose(
                modifier = modifier,
                onNextButton = {
                    navController.navigate(NestedScreen.VisitScreen.name)
                },
            )
        }
        composable(route = NestedScreen.VisitScreen.name) {
            VisitCompose(
                modifier = modifier,
                onNextButton = {
                    navController.navigate(NestedScreen.StartCVScreen.name)
                },
            )
        }
        composable(route = NestedScreen.StartCVScreen.name) {
            StartCV(
                modifier = modifier,
                onNextButton = {
                    navController.popBackStack(NestedScreen.RootFlow.name, inclusive = false)
                    navController.navigate(NestedScreen.MainFlow.name)
                },
            )
        }
    }
}
