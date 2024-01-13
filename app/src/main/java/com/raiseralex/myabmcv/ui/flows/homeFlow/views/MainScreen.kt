package com.raiseralex.myabmcv.ui.flows.homeFlow.views

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.raiseralex.myabmcv.R
import com.raiseralex.myabmcv.navigation.MainGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.main_screen))
                },
            )
        },

    ) { paddingValues ->
        MainGraph(navController = navController, modifier = modifier.padding(paddingValues))
    }
}

@Composable
fun MainBottomNavigationBar(
    modifier: Modifier,
    onClickHome: (route: String) -> Unit,
) {
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
    ) {
        getList().forEachIndexed {
                index, tabBarItem ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    onClickHome(tabBarItem.route)
                },
                icon = {
                    Icon(
                        imageVector = tabBarItem.icon,
                        contentDescription = stringResource(id = tabBarItem.label),
                        tint = MaterialTheme.colorScheme.primary,
                    )
                },
                label = {
                    tabBarItem.label
                },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabBarIconView(
    isSelected: Boolean,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    title: Unit,
    badgeAmount: Int? = null,
) {
    BadgedBox(badge = { TabBarBadgeView(badgeAmount) }) {
        Icon(
            tint = Color.Black,
            imageVector = if (isSelected) { selectedIcon } else { unselectedIcon },
            contentDescription = title.toString(),
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TabBarBadgeView(count: Int? = null) {
    if (count != null) {
        Badge {
            Text(count.toString())
        }
    }
}

@Composable
fun MoreView1() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text("Thing 1")
        Text("Thing 2")
        Text("Thing 3")
    }
}

@Composable
fun MoreView2() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text("Thing 1")
        Text("Thing 2")
        Text("Thing 3")
        Text("Thing 4")
        Text("Thing 5")
    }
}

sealed class BottomNavItem(val route: String, val icon: ImageVector, @StringRes val label: Int) {
    object Home : BottomNavItem("nav_bar_home", Icons.Default.Home, R.string.home_nav_bar)
    object History : BottomNavItem("nav_bar_history", Icons.Default.Face, R.string.history_nav_bar)
    object Skills : BottomNavItem("nav_bar_skills", Icons.Default.Build, R.string.skills_nav_bar)
    object References : BottomNavItem("nav_bar_references", Icons.Default.List, R.string.references_nav_bar)
}

fun getList(): List<BottomNavItem> {
    return listOf(
        BottomNavItem.Home,
        BottomNavItem.History,
        BottomNavItem.Skills,
        BottomNavItem.References,
    )
}
