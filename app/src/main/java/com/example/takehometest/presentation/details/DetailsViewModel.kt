package com.example.takehometest.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.takehometest.domain.usecases.GetCharacterDetailsUseCase
import com.example.takehometest.presentation.mapper.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val state = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<DetailsSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun onAction(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.OnGetDetails -> loadCharacterDetails(event.id)
            DetailsEvent.OnBackClick -> viewModelScope.launch {
                _sideEffect.emit(DetailsSideEffect.NavigateBack)
            }

            is DetailsEvent.ShowError -> viewModelScope.launch {
                _sideEffect.emit(DetailsSideEffect.ShowToast(event.message))
                _state.value = DetailsUiState.Error(event.message)
            }
        }
    }

    private fun loadCharacterDetails(id: Int) {
        viewModelScope.launch {
              _state.value = DetailsUiState.Loading
            try {
                val details = getCharacterDetailsUseCase.invoke(id)
                _state.value = DetailsUiState.Success(character = details.toUiModel())
            } catch (e: Exception) {
                _state.value = DetailsUiState.Error(e.message ?: "Unknown error")
                _sideEffect.emit(DetailsSideEffect.ShowToast(e.message ?: "Unknown error"))
            }
        }


    }
}