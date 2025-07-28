package com.example.takehometest.presentation.details

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.takehometest.AppState
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailsRout(
    appState: AppState,
    itemId: Int,
    onBack: () -> Unit = appState.mainNavController::popBackStack,
    viewModel: DetailsViewModel = hiltViewModel<DetailsViewModel>(),
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value
    val context = LocalContext.current
    LaunchedEffect(itemId) {
        viewModel.onAction(DetailsEvent.OnGetDetails(itemId))
    }
    LaunchedEffect(Unit) {
        viewModel.sideEffect.collectLatest { effect ->
            when (effect) {
                DetailsSideEffect.NavigateBack -> onBack()
                is DetailsSideEffect.ShowToast -> Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
    DetailsScreen(
        state = state,
        onAction = viewModel::onAction,
    )
}