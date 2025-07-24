package com.example.takehometest.presentation.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.takehometest.AppState
import kotlinx.coroutines.flow.collectLatest


@Composable
fun ListScreenRout(
    modifier: Modifier = Modifier,
    appState: AppState,
    viewModel: ListViewModel = hiltViewModel<ListViewModel>(),
) {

    val state = viewModel.state.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collectLatest { effect ->
            when (effect) {
                ListSideEffect.NavigateBack -> TODO()
                is ListSideEffect.NavigateToDetails -> TODO()
                is ListSideEffect.ShowToast -> TODO()
            }
        }
    }
    ListScreen(
        state = state,
        onAction = viewModel::onAction,
    )
}