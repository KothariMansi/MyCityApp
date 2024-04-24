package com.example.mycityapp.ui.model


sealed class Recommendations(
    open val name: String,
    open val category: String,
    open val description: String
) {

    data class CoffeeShops(
        override val name: String,
        override val category: String,
        override val description: String
    ) : Recommendations( name, category, description )

    data class Restaurant(
        override val name: String,
        override val category: String,
        override val description: String
    ) : Recommendations(name, category, description)

    data class Parks(
        override val name: String,
        override val category: String,
        override val description: String
    ): Recommendations(name, category, description)

}