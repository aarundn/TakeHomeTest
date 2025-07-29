package com.example.takehometest.presentation.list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.takehometest.R
import com.example.takehometest.presentation.list.ListEvent
import com.example.takehometest.presentation.list.ListUiState
import com.example.takehometest.presentation.model.CharacterUi

@Composable
fun LazyList(
    listState: LazyListState,
    modifier: Modifier,
    state: ListUiState.Success,
    characters: List<CharacterUi>,
    onAction: (ListEvent) -> Unit
) {
    LazyColumn(
        state = listState,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!state.isSearchMode)
            item {
                ListHeader()
                Spacer(Modifier.height(16.dp))
            }

        when {

            characters.isEmpty() -> item {
                EmptyListScreen(
                    message = stringResource(R.string.no_characters_found),
                    modifier = Modifier.fillMaxSize()
                )
            }

            else -> items(
                characters.size,
                key = { index -> characters[index].id }) { index ->
                val character = characters[index]
                ListItems(
                    character = character,
                    onGoToDetails = { id -> onAction(ListEvent.OnNavigateToDetails(id)) }
                )
            }
        }
        item {
            val isLoadingMore = state.isLoadingMore == true
            if (isLoadingMore) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(32.dp),
                )
            }
        }
    }
}