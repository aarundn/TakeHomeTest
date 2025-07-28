package com.example.takehometest.presentation.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.takehometest.presentation.comon.components.LoadingIndicator
import com.example.takehometest.presentation.details.components.DetailsBody
import com.example.takehometest.presentation.details.components.DetailsHeader
import com.example.takehometest.presentation.model.CharacterUi
import com.example.takehometest.ui.theme.TakeHomeTestTheme

@Composable
fun DetailsScreen(
    state: DetailsUiState,
    onAction: (DetailsEvent) -> Unit,
) {

    Scaffold { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (state) {
                is DetailsUiState.Success -> DetailsContent(
                    character = state.character,
                    onAction = onAction
                )

                is DetailsUiState.Error -> onAction(DetailsEvent.ShowError(state.message))
                DetailsUiState.Loading -> LoadingIndicator(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun DetailsContent(
    character: CharacterUi,
    onAction: (DetailsEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        DetailsHeader(
            character = character,
            onBackClick = { onAction(DetailsEvent.OnBackClick) }
        )
        DetailsBody(character = character)
    }
}


@Preview(showBackground = true)
@Composable
private fun DetailsScreenPreview() {
    TakeHomeTestTheme {
        DetailsScreen(
            state = DetailsUiState.Success(
                character = CharacterUi(
                    id = 1,
                    name = "John Doe",
                    image = "https://example.com/image.jpg",
                    status = "Alive",
                    species = "Human",
                )
            ),
            onAction = {}
        )
    }
}