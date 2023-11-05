package com.zuoguan.counterdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.zuoguan.counterdemo.ui.theme.CounterDemoTheme
import androidx.navigation.compose.rememberNavController
import com.zuoguan.counterdemo.pages.main.MainPageView
import com.zuoguan.counterdemo.pages.start.StartPageView
import com.zuoguan.counterdemo.route.Route
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterDemoTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Route.Start.route) {
                    composable(Route.Start.route) {
                        StartPageView(navController)
                    }
                    composable(Route.Main.route) {
                        MainPageView()
                    }
                }
            }
        }
    }
}
