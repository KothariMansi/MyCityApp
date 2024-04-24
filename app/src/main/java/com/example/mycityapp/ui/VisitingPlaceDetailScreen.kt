package com.example.mycityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.mycityapp.R
import com.example.mycityapp.ui.data.VisitingPlaces


@Composable
fun DetailScreen(
    selectedPlace: VisitingPlaces,
    onBackButtonClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                title = R.string.detail,
                onBackButtonClick = onBackButtonClick
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Image(painter = painterResource(selectedPlace.img), contentDescription = selectedPlace.name)
            Text(text = selectedPlace.name)
            Text(text = selectedPlace.category)
            Text(text = selectedPlace.description)

        }
    }

    
}

@Composable
fun DetailScreenPreview() {
    DetailScreen(
        onBackButtonClick = {},
        selectedPlace = VisitingPlaces(
            img = R.drawable.birlamandir,
            name = "Jantat",
            category = "pata ni",
            description = "Nice Place. Must Visit."
        )
    )
}