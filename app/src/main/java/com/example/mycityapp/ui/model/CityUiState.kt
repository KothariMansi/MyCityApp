package com.example.mycityapp.ui.model

import com.example.mycityapp.ui.data.VisitingPlaces
import com.example.mycityapp.ui.data.VisitingPlacesRepository.visitingPlaces

data class CityUiState (
    val placesList: List<VisitingPlaces> = visitingPlaces,
    val currentPlace: VisitingPlaces = visitingPlaces[0],
    val expanded: Boolean = false,

)