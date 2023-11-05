package com.zuoguan.counterdemo.pages.main

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zuoguan.counterdemo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPageView(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                barItems.forEach{item ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                        onClick = { navController.navigateTo(item.route) },
                        icon = {
                            Icon(
                                modifier = Modifier.size(25.dp),
                                painter = painterResource(id = item.icon),
                                contentDescription = item.route,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        },
                        label = {
                            Text(text = item.route)
                        })
                }
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)){
            NavHost(navController = navController, startDestination = BarItem.Page1.route) {
                composable(BarItem.Page1.route) { PageA() }
                composable(BarItem.Page2.route) { PageB() }
            }
        }
    }
}

sealed class BarItem(val route: String, @DrawableRes val icon: Int) {
    object Page1 : BarItem("PAGE 1", R.drawable.a)
    object Page2 : BarItem("PAGE 2", R.drawable.b)
}

val barItems = arrayListOf<BarItem>(BarItem.Page1, BarItem.Page2)

fun NavController.navigateTo(route: String){
    this.navigate(route){
        popUpTo(this@navigateTo.graph.findStartDestination().id)
        launchSingleTop=true
    }
}