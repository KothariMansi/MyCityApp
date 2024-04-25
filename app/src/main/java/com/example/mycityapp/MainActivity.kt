package com.example.mycityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.ui.CafeScreen
import com.example.mycityapp.ui.DetailScreen
import com.example.mycityapp.ui.StarterScreen
import com.example.mycityapp.ui.VisitingPlacesScreen
import com.example.mycityapp.ui.data.DataSource
import com.example.mycityapp.ui.model.CityViewModel
import com.example.mycityapp.ui.theme.MyCityAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(activity = this)
                    MyCityApp(windowSize = windowSize.widthSizeClass)
                }
            }
        }
    }
}


enum class MyCityScreen{
    Start,
    VisitingPlaces,
    DetailScreen,
    CafeScreen

}

enum class WindowSize{
    ListOnly,
    ListAndDetail
}

@Composable
fun MyCityApp(
    navController: NavHostController = rememberNavController(),
    windowSize: WindowWidthSizeClass,

    ) {
    val viewModel: CityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val contentType: WindowSize

    when (windowSize) {
        WindowWidthSizeClass.Compact -> contentType = WindowSize.ListOnly
        WindowWidthSizeClass.Medium -> contentType = WindowSize.ListAndDetail
        WindowWidthSizeClass.Expanded -> contentType = WindowSize.ListAndDetail
        else -> contentType = WindowSize.ListOnly

    }

    NavHost(navController = navController, startDestination = MyCityScreen.Start.name) {


        composable(MyCityScreen.Start.name){
            StarterScreen(
                onButtonPressed = { navController.navigate(MyCityScreen.VisitingPlaces.name) },
            )
        }

        composable(MyCityScreen.VisitingPlaces.name) {
            VisitingPlacesScreen(
                //selectedPlaces = uiState.currentPlace,
                onClick = {
                    viewModel.updateCurrentPlace(currentPlace = it)
                    if (contentType ==  WindowSize.ListOnly) navController.navigate(MyCityScreen.DetailScreen.name)
                },
                onBackButtonClick =  { navController.popBackStack() },
                expanded = uiState.expanded,
                onMenuClick = { viewModel.expandMenuItem(uiState.expanded) },
                onCafeButtonClick = { navController.navigate(MyCityScreen.CafeScreen.name) },
                screenType = MyCityScreen.VisitingPlaces,
                contentType = contentType,
                selectedPlaces = uiState.currentPlace
            )
        }

        composable(MyCityScreen.DetailScreen.name) {
            DetailScreen(
                selectedPlace = uiState.currentPlace,
                onBackButtonClick = { navController.popBackStack() },
                expanded = uiState.expanded,
                onMenuClick = { viewModel.expandMenuItem(uiState.expanded) },
                onCafeButtonClick = { navController.navigate(MyCityScreen.CafeScreen.name) },
                screenType = MyCityScreen.DetailScreen,
                contentType = contentType
            )
        }

        composable(MyCityScreen.CafeScreen.name){
            CafeScreen(
                expanded = uiState.expanded,
                screenType = MyCityScreen.CafeScreen,
                onBackButtonClick = { navController.popBackStack()
                    viewModel.expandMenuItem(uiState.expanded)},
                onMenuClick = { viewModel.expandMenuItem(uiState.expanded)},
                coffeeShopsList = DataSource.coffeeShopsList,
            )
        }
    }
}
