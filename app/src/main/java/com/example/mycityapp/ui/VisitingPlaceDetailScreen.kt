package com.example.mycityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.R
import com.example.mycityapp.ui.data.VisitingPlaces


@Composable
fun DetailScreen(
    selectedPlace: VisitingPlaces,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
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
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(it).fillMaxWidth()
        ) {
            Image(painter = painterResource(selectedPlace.img),
                contentDescription = selectedPlace.name,
                modifier = modifier.padding(8.dp).fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = selectedPlace.name,
                style = MaterialTheme.typography.displayLarge,
                modifier = modifier.padding(start = 8.dp, bottom = 4.dp)
            )
            Text(text = selectedPlace.category,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary,
                modifier = modifier.padding(start = 8.dp, bottom = 4.dp)
            )
            Text(text = selectedPlace.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = modifier.padding(start = 8.dp, bottom = 4.dp)
            )

        }
    }

    
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        onBackButtonClick = {},
        selectedPlace = VisitingPlaces(
            img = R.drawable.birlamandir,
            name = "Jantar Mantar",
            category = "pata ni",
            description = "Nice Place. Must Visit."
        )
    )
}