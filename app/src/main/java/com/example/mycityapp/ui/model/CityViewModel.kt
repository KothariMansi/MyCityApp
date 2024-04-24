package com.example.mycityapp.ui.model

import androidx.lifecycle.ViewModel
import com.example.mycityapp.ui.data.VisitingPlaces
import com.example.mycityapp.ui.data.VisitingPlacesRepository.visitingPlaces
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CityViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(CityUiState(
        placesList = visitingPlaces,
        currentPlace = visitingPlaces.getOrElse(0) {
            visitingPlaces[0]
        }
    ))
    val uiState:StateFlow<CityUiState> = _uiState

    fun updateCurrentPlace(currentPlace: VisitingPlaces) {
        _uiState.update {
            it.copy(
                currentPlace = currentPlace
            )
        }
    }


}
