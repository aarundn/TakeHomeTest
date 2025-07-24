package com.example.takehometest.presentation.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.takehometest.ui.theme.TakeHomeTestTheme


@Composable
fun ListScreen(
    onAction: (ListEvent) -> Unit,
     state: ListUiState,
) {

}

@Preview
@Composable
private fun ListScreenPreview() {
    TakeHomeTestTheme {
        ListScreen(
            state = ListUiState.Loading,
            onAction = {}
        )
    }
}