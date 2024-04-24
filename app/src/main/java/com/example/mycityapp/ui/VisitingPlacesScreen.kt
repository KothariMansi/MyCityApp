package com.example.mycityapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.R
import com.example.mycityapp.ui.data.VisitingPlaces
import com.example.mycityapp.ui.data.VisitingPlacesRepository.visitingPlaces
import com.example.mycityapp.ui.theme.MyCityAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    @StringRes title: Int,
    onBackButtonClick: () -> Unit
) {
    TopAppBar(
        title = {
                Text(text = stringResource(title))
        },
        navigationIcon = {
            IconButton(
                onClick = { onBackButtonClick() }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            }
        }

    )
}

@Composable
fun VisitingPlacesItem(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Text(text = name, modifier = modifier.padding(15.dp))
    }

}

@Composable
fun VisitingPlacesScreen(
    //selectedPlaces: VisitingPlaces,
    onClick: (VisitingPlaces) -> Unit,
    onBackButtonClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                title = R.string.visiting_places,
                onBackButtonClick = onBackButtonClick
            )
        }
    ) {
        LazyColumn(contentPadding = it) {
            items(visitingPlaces) {visitingPlace->
                VisitingPlacesItem(name = visitingPlace.name,
                    onClick = { onClick(visitingPlace) }
                )
            }

        }

    }
}

@Preview
@Composable
fun VisitingPlacesPreview() {
    MyCityAppTheme {
        VisitingPlacesScreen(
            onBackButtonClick = {},
            onClick = {},

        )
    }
}
