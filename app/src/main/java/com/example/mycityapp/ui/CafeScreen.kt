package com.example.mycityapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mycityapp.R


@Composable
fun CafeScreen(
    expanded: Boolean,
    screenType: MyCityScreen,
    onBackButtonClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                title = R.string.cafeteria,
                onBackButtonClick = onBackButtonClick ,
                expanded = expanded,
                onMenuClick = onMenuClick,
                onCafeButtonClick = {},
                screenType = screenType
            )
        }

    ) {

        Column(Modifier.padding(it)) {
            Text(text = "Cafe Screen")
        }

    }

}