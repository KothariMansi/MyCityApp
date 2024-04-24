package com.example.mycityapp.ui.data

import androidx.annotation.DrawableRes
import com.example.mycityapp.R


data class VisitingPlaces (
    @DrawableRes val img: Int,
    val name: String,
    val category: String,
    val description: String
)
object VisitingPlacesRepository{
    val visitingPlaces = listOf(
        VisitingPlaces(
            img = R.drawable.amberpalace,
            name = "Hawa Mahal - Palace of Wind",
            category = "Points of Interest & Landmarks",
            description = "Made of red and pink sandstone, Jaipur's signature palace of unusual architecture is a stunning example of local artistry." +
                    " The top of the Hawa Mahal offers an excellent view over the city."
        ),
        VisitingPlaces(
            img = R.drawable.jantar_mantar_jaipur,
            name = "Jantar Mantar",
            category = "Observatories & Planetariums",
            description = "The site is an outdoor collection of ancient astronomical instruments, including the largest sundial in the world."
        ),
        VisitingPlaces(
            img = R.drawable.sheeshmahal,
            name = "Sheesh Mahal (Hall of Mirrors)",
            category = "Architectural Buildings",
            description = "... many small pieces of mirrors that are artfully embedded in the walls and roof of this section of the Amber Palace."
        ),
        VisitingPlaces(
            img = R.drawable.birlamandir,
            name = "Birla Mandir Temple",
            category = "Temple",
            description = "The three huge domes of the temple represent three different approaches to the religion."
        )


    )


}
