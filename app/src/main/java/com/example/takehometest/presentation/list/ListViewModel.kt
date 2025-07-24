package com.example.takehometest.presentation.list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(

): ViewModel(){


     private val _state = MutableStateFlow(ListUiState.Loading)
     val state = _state.asStateFlow()

     private val _sideEffect = MutableSharedFlow<ListSideEffect>()
     val sideEffect = _sideEffect.asSharedFlow()

     fun onAction(event: ListEvent) {
         when (event) {
             ListEvent.OnBackClick -> TODO()
             is ListEvent.OnGetItems -> TODO()
             is ListEvent.OnItemClick -> TODO()
             is ListEvent.OnNavigateToDetails -> TODO()
             is ListEvent.OnShowToast -> TODO()
         }
     }
}