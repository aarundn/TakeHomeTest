package com.example.takehometest.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.takehometest.domain.usecases.GetCharactersUseCase
import com.example.takehometest.presentation.mapper.toUiModel
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
            ListEvent.OnBackClick -> TODO()
            is ListEvent.OnGetItems -> {
                loadInitialItems(event.page)
            }

            is ListEvent.OnItemClick -> TODO()
            is ListEvent.OnNavigateToDetails -> viewModelScope.launch {
                _sideEffect.emit(
                    ListSideEffect.NavigateToDetails(itemId = event.itemId)
                )
            }
            is ListEvent.OnShowToast -> TODO()
        }
    }

    private fun loadInitialItems(page: Int) {
        viewModelScope.launch(IO) {
            _state.value = ListUiState.Loading
            getCharactersUseCase.invoke(page = page)
                .catch { e ->
                    _state.value = ListUiState.Error(e.message ?: "Unknown error")
                }
                .collect { characters ->
                    _state.value = ListUiState.Success(items = characters.toUiModel())
                }
        }
    }
}