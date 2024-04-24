package com.example.mycityapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.R
import com.example.mycityapp.ui.data.VisitingPlaces
import com.example.mycityapp.ui.model.CityViewModel
import com.example.mycityapp.ui.theme.MyCityAppTheme


enum class MyCityScreen{
    Start,
    VisitingPlaces,
    DetailScreen

}

@Composable
fun MyCityApp(
    navController: NavHostController = rememberNavController()
) {
    val viewModel: CityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    NavHost(navController = navController, startDestination = MyCityScreen.Start.name) {
        composable(MyCityScreen.Start.name){
            StarterScreen(
                onButtonPressed = { navController.navigate(MyCityScreen.VisitingPlaces.name) },
                //selectedPlaces = uiState.currentPlace
            )
        }

        composable(MyCityScreen.VisitingPlaces.name) {
            VisitingPlacesScreen(
                //selectedPlaces = uiState.currentPlace,
                onClick = {
                    viewModel.updateCurrentPlace(currentPlace = it)
                    navController.navigate(MyCityScreen.DetailScreen.name)
                },
                onBackButtonClick =  { navController.popBackStack() }
            )
        }

        composable(MyCityScreen.DetailScreen.name) {
            DetailScreen(
                selectedPlace = uiState.currentPlace,
                onBackButtonClick = { navController.popBackStack() }
            )
        }
    }
}


@Composable
fun StarterScreen(
    modifier: Modifier = Modifier,
    onButtonPressed: () -> Unit

) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(12.dp)
    ) {
        Text(
            text = stringResource(R.string.jaipur),
            style = MaterialTheme.typography.displayLarge,
            modifier = modifier
        )

        Text(
            text = "One of the best planned cities of India, Jaipur is the capital city of the state of Rajasthan." +
                    " Its features of beautiful Architecture, Town Planning, Arts and Crafts, Culture, tourism have endowed it with uniqueness in India's urban character.",
            style = MaterialTheme.typography.bodySmall,
            modifier = modifier
        )
        Spacer(modifier = modifier.padding(16.dp))

        Button(onClick = { onButtonPressed() }) {
            Text(text = stringResource(R.string.let_s_visit))
        }

    }
}

@Preview
@Composable
fun MyCityAppPreview() {
    MyCityAppTheme {
        StarterScreen(onButtonPressed = {})
    }
}