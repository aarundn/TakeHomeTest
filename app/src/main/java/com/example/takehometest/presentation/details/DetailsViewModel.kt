package com.example.takehometest.presentation.details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(

): ViewModel(){

    private val _state = MutableStateFlow(DetailsUiState.Loading)
    val state = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<DetailsSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun onAction(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.OnGetDetails -> TODO()
            is DetailsEvent.OnAddToCart -> TODO()
            is DetailsEvent.OnRemoveFromCart -> TODO()
            DetailsEvent.OnBackClick -> TODO()
        }
    }
}