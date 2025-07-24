package com.example.takehometest.presentation.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.takehometest.ui.theme.TakeHomeTestTheme

@Composable
fun DetailsScreen(
    state: DetailsUiState,
    onAction : (DetailsEvent) -> Unit,
) {

}

@Preview(showBackground = true)
@Composable
private fun DetailsScreenPreview() {
    TakeHomeTestTheme {
        DetailsScreen(
            state = DetailsUiState.Loading,
            onAction = {}
        )
    }
}