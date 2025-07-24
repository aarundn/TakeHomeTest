package com.example.takehometest.presentation.list

import com.example.takehometest.presentation.model.CharacterUi


sealed class ListUiState {

    object Loading : ListUiState()

    data class Success(val items: List<CharacterUi>) : ListUiState()

    data class Error(val message: String) : ListUiState()

}

sealed class ListEvent {
    data class OnGetItems(val page: Int) : ListEvent()
    data class OnItemClick(val id: String) : ListEvent()
    data class OnNavigateToDetails(val itemId: String) : ListEvent()
    object OnBackClick : ListEvent()
    data class OnShowToast(val message: String) : ListEvent()
}

sealed interface ListSideEffect {
    data class ShowToast(val message: String) : ListSideEffect
    data class NavigateToDetails(val itemId: String) : ListSideEffect
    object NavigateBack : ListSideEffect
}