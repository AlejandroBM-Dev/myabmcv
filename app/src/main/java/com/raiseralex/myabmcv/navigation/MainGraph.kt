package com.raiseralex.myabmcv.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raiseralex.myabmcv.ui.flows.homeFlow.views.BottomNavItem
import com.raiseralex.myabmcv.ui.flows.homeFlow.views.HistoryNavScreen
import com.raiseralex.myabmcv.ui.flows.homeFlow.views.HomeNavScreen
import com.raiseralex.myabmcv.ui.flows.homeFlow.views.MoreView1
import com.raiseralex.myabmcv.ui.flows.homeFlow.views.MoreView2

@ExperimentalMaterial3Api
@Composable
fun MainGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        modifier = modifier.fillMaxWidth().fillMaxHeight(),
        navController = navController,
        route = NestedScreen.MainFlow.name,
        startDestination = BottomNavItem.Home.route,
    ) {
        composable(BottomNavItem.Home.route) {
            HomeNavScreen()
        }
        composable(BottomNavItem.History.route) {
            HistoryNavScreen()
        }

        composable(BottomNavItem.Skills.route) {
            MoreView1()
        }

        composable(BottomNavItem.References.route) {
            MoreView2()
        }
    }
}
