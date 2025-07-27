package com.example.takehometest.presentation.list

import com.example.takehometest.presentation.model.CharacterUi


sealed class ListUiState {

    object Loading : ListUiState()

    data class Success(
        val items: List<CharacterUi> = emptyList(),
        var isLoadingMore: Boolean = false,
        var reachedEndOfList: Boolean = false,
        var currentPage: Int = 0,
    ) : ListUiState()

    data class Error(val message: String) : ListUiState()

}

sealed class ListEvent {
    data class OnGetInitialItems(val page: Int) : ListEvent()
    object OnLoadMore : ListEvent()
    data class OnNavigateToDetails(val itemId: Int) : ListEvent()
    data class OnShowToast(val message: String) : ListEvent()
}

sealed interface ListSideEffect {
    data class ShowToast(val message: String) : ListSideEffect
    data class NavigateToDetails(val itemId: Int) : ListSideEffect
}