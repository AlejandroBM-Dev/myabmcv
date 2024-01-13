package com.raiseralex.myabmcv.ui

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.raiseralex.myabmcv.R
import com.raiseralex.myabmcv.navigation.NestedScreen
import com.raiseralex.myabmcv.navigation.RootNavigationGraph
import com.raiseralex.myabmcv.ui.flows.welcomeFlow.viewmodels.ThemeViewModel

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MyCvApp()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCvApp(
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        topBar = {
            MyCvAppBar(
                navController = navController,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
        },
    ) { padding ->
        RootNavigationGraph(navHostController = navController, Modifier.padding(padding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCvAppBar(
    navController: NavHostController,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    themeViewModel: ThemeViewModel = hiltViewModel(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = NestedScreen.valueOf(
        backStackEntry?.destination?.route ?: NestedScreen.WelcomeScreen.name,
    )
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = currentScreen.title),
                fontFamily = themeViewModel.getFontFamily(),
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
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
