package com.example.mycityapp.ui


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.R
import com.example.mycityapp.ui.data.DataSource.coffeeShopsList
import com.example.mycityapp.ui.model.Recommendations.CoffeeShops
import com.example.mycityapp.ui.theme.MyCityAppTheme


@Composable
fun CafeScreen(
    expanded: Boolean,
    screenType: MyCityScreen,
    onBackButtonClick: () -> Unit,
    onMenuClick: () -> Unit,
    coffeeShopsList : List<CoffeeShops>
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
        LazyColumn(contentPadding = it) {
            items(coffeeShopsList) { it ->
                CafeScreenItem(
                    name = it.name,
                    category = it.category,
                    description = it.description
                )
            }
        }
    }
}

@Composable
fun CafeScreenItem(
    name: String,
    category: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Text(text = name,
            style = MaterialTheme.typography.displayLarge,
            modifier = modifier.padding(start = 8.dp, bottom = 4.dp)

        )
        Text(text = category,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary,
            modifier = modifier.padding(start = 8.dp, bottom = 4.dp)

        )
        Text(text = description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier.padding(start = 8.dp, bottom = 4.dp)

        )
    }
}


@Preview
@Composable
fun CafeScreenItemPreview() {
    MyCityAppTheme {
        CafeScreenItem(name = "Jaipur Baking Company",
            category = "Cafe",
            description = "Express yourself with Espresso."
        )
    }

}

@Preview
@Composable
fun CafeScreenPreview() {
    MyCityAppTheme{
        CafeScreen(
            expanded = false,
            screenType = MyCityScreen.CafeScreen,
            onBackButtonClick = { },
            onMenuClick = { },
            coffeeShopsList = coffeeShopsList
        )
    }
}