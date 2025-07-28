package com.example.takehometest.presentation.details

import com.example.takehometest.presentation.model.CharacterUi


sealed class DetailsUiState {
    data class Success(val character: CharacterUi) : DetailsUiState()
    data class Error(val message: String) : DetailsUiState()
    object Loading : DetailsUiState()
}
sealed class DetailsEvent {
    data class OnGetDetails(val id: Int) : DetailsEvent()
    object OnBackClick : DetailsEvent()
    data class ShowError(val message: String) : DetailsEvent()
}

sealed interface DetailsSideEffect {
    data class ShowToast(val message: String) : DetailsSideEffect
    object NavigateBack : DetailsSideEffect
}
