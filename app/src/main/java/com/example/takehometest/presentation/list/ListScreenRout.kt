package com.example.takehometest.presentation.list

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.takehometest.AppState
import kotlinx.coroutines.flow.collectLatest


@Composable
fun ListScreenRout(
    appState: AppState,
    viewModel: ListViewModel = hiltViewModel<ListViewModel>(),
) {
    val context = LocalContext.current
    val state = viewModel.state.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) {
        viewModel.onAction(ListEvent.OnGetInitialItems(1))
        viewModel.sideEffect.collectLatest { effect ->
            when (effect) {
                is ListSideEffect.NavigateToDetails -> appState.goToDetail(effect.itemId)
                is ListSideEffect.ShowToast -> Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
    ListScreen(
        state = state,
        onAction = viewModel::onAction,
    )
}