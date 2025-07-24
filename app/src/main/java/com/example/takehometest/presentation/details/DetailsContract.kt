package com.example.takehometest.presentation.details

import com.example.takehometest.presentation.model.CharacterUi


sealed class DetailsUiState {
    data class Success(val details: CharacterUi) : DetailsUiState()
    data class Error(val message: String) : DetailsUiState()
    object Loading : DetailsUiState()
}
sealed class DetailsEvent {
    data class OnGetDetails(val id: String) : DetailsEvent()
    data class OnAddToCart(val id: String) : DetailsEvent()
    data class OnRemoveFromCart(val id: String) : DetailsEvent()
    object OnBackClick : DetailsEvent()
}

sealed interface DetailsSideEffect {
    data class ShowToast(val message: String) : DetailsSideEffect
    object NavigateBack : DetailsSideEffect
}
