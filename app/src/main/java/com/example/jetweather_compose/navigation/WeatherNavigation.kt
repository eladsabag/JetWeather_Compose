package com.example.jetweather_compose.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetweather_compose.screens.main.MainScreen
import com.example.jetweather_compose.screens.main.MainViewModel
import com.example.jetweather_compose.screens.search.SearchScreen
import com.example.jetweather_compose.screens.splash.WeatherSplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WeatherScreens.SplashScreen.name) {

        composable(WeatherScreens.SplashScreen.name) {
            WeatherSplashScreen(navController)
        }

        composable(WeatherScreens.MainScreen.name) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController, mainViewModel)
        }

        composable(WeatherScreens.SearchScreen.name) {
            SearchScreen(navController)
        }
    }
}