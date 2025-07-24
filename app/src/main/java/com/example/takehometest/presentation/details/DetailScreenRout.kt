package com.example.takehometest.presentation.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.takehometest.AppState
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailsRout(
    modifier: Modifier = Modifier,
    appState: AppState,
    itemId: Int,
    viewModel: DetailsViewModel = hiltViewModel<DetailsViewModel>(),
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collectLatest { effect ->
            when (effect) {
                DetailsSideEffect.NavigateBack -> TODO()
                is DetailsSideEffect.ShowToast -> TODO()
            }
        }
    }
    DetailsScreen(
        state = state,
        onAction = viewModel::onAction,
    )
}