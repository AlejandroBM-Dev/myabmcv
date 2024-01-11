package com.raiseralex.myabmcv.ui.welcomeFlow.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.raiseralex.myabmcv.R
import com.raiseralex.myabmcv.navigation.AppScreen

@Composable
fun MyCvApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = AppScreen.valueOf(
        backStackEntry?.destination?.route ?: AppScreen.WelcomeScreen.name,
    )

    Scaffold(
        topBar = {
            MyCvAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
        },
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AppScreen.WelcomeScreen.name,
            modifier = modifier.padding(innerPadding),
        ) {
            composable(route = AppScreen.WelcomeScreen.name) {
                WelcomeCompose(
                    modifier = modifier,
                    onNextButton = {
                        navController.navigate(AppScreen.VisitScreen.name)
                    },
                )
            }
            composable(route = AppScreen.VisitScreen.name) {
                VisitCompose(
                    modifier = modifier,
                    onNextButton = {
                        navController.navigate(AppScreen.StartCVScreen.name)
                    },
                )
            }
            composable(route = AppScreen.StartCVScreen.name) {
                StartCV(
                    modifier = modifier,
                    onNextButton = {
                        navController.popBackStack(AppScreen.WelcomeScreen.name, inclusive = false)
                    },
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCvAppBar(
    currentScreen: AppScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = { Text(text = stringResource(id = currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button),
                    )
                }
            }
        },
    )
}
