package com.example.takehometest.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.takehometest.domain.usecases.GetCharactersUseCase
import com.example.takehometest.presentation.list.ListSideEffect.NavigateToDetails
import com.example.takehometest.presentation.list.ListSideEffect.ShowToast
import com.example.takehometest.presentation.mapper.toUiModel
import com.example.takehometest.presentation.model.CharacterUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {


    private val _state = MutableStateFlow<ListUiState>(ListUiState.Loading)
    val state = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<ListSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun onAction(event: ListEvent) {
        when (event) {
            is ListEvent.OnGetInitialItems -> {
                _state.value = ListUiState.Loading
                loadItems(event.page)
            }
            is ListEvent.OnNavigateToDetails -> viewModelScope.launch {
                _sideEffect.emit(NavigateToDetails(itemId = event.itemId))
            }
            is ListEvent.OnShowToast -> viewModelScope.launch {
                _sideEffect.emit(ShowToast(message = event.message))
            }
            ListEvent.OnLoadMore -> loadMoreItems()

        }
    }

    private fun loadMoreItems() {
        val currentState = _state.value
        val canLoadMore = currentState is ListUiState.Success &&
                !currentState.isLoadingMore &&
                !currentState.reachedEndOfList

        if (canLoadMore) {
            _state.value = currentState.copy(isLoadingMore = true)
            val nextPage = currentState.currentPage + 1
            loadItems(nextPage, currentState.items)
        }
    }

    private fun loadItems(page: Int, previousItems: List<CharacterUi> = emptyList()) {
        viewModelScope.launch(IO) {
            getCharactersUseCase.invoke(page = page)
                .catch { e ->
                    _state.value = ListUiState.Error(e.message ?: "Unknown error")
                }
                .collect { result ->
                    val isLastPage = result.totalPages <= page
                    _state.value = ListUiState.Success(
                        items = previousItems + result.characters.toUiModel(),
                        isLoadingMore = false,
                        reachedEndOfList = isLastPage,
                        currentPage = page
                    )
                }
        }
    }
}