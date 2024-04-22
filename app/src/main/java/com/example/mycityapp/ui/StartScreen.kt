package com.example.mycityapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.R
import com.example.mycityapp.ui.theme.MyCityAppTheme

@Composable
fun MyCityApp(
    modifier: Modifier = Modifier
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

        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(R.string.let_s_visit))
        }

    }
}

@Preview
@Composable
fun MyCityAppPreview() {
    MyCityAppTheme {
        MyCityApp()
    }
}