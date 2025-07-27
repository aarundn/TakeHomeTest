package com.example.takehometest.presentation.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.takehometest.R
import com.example.takehometest.presentation.comon.components.LoadingIndicator
import com.example.takehometest.presentation.list.components.EmptyAndErrorList
import com.example.takehometest.presentation.list.components.ListHeader
import com.example.takehometest.presentation.list.components.ListItems
import com.example.takehometest.presentation.model.CharacterUi
import com.example.takehometest.ui.theme.TakeHomeTestTheme


@Composable
fun ListScreen(
    onAction: (ListEvent) -> Unit,
    state: ListUiState,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (state) {
                is ListUiState.Loading -> LoadingIndicator(modifier = Modifier.fillMaxSize())


                is ListUiState.Error -> EmptyAndErrorList(
                    message = state.message,
                    modifier = Modifier.fillMaxSize()
                )

                is ListUiState.Success -> {
                    ListContent(
                        characters = state.items,
                        onAction = onAction,
                        state = state,
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }
        }
    }

}


@Composable
fun ListContent(
    characters: List<CharacterUi>,
    onAction: (ListEvent) -> Unit,
    state: ListUiState,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()
    LaunchedEffect(listState) {
        snapshotFlow {
            val layoutInfo = listState.layoutInfo
            val lastVisibleItemIndex = layoutInfo.visibleItemsInfo.lastOrNull()?.index
            val totalItems = layoutInfo.totalItemsCount
            lastVisibleItemIndex to totalItems

        }.collect { (lastVisibleIndex, totalItems) ->

            if (lastVisibleIndex != null && totalItems > 0) {
                if (lastVisibleIndex >= totalItems - 2) {
                    onAction(ListEvent.OnLoadMore)
                }
            }
        }
    }
    LazyColumn(
        state = listState,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        item { ListHeader() }
        when {

            characters.isEmpty() -> item {
                EmptyAndErrorList(
                    message = stringResource(R.string.no_characters_found),
                    modifier = modifier.fillMaxSize()
                )
            }

            else -> items(characters.size,
                key = { index -> characters[index].id }) { index ->
                val character = characters[index]
                ListItems(
                    character = character,
                    onGoToDetails = { id ->
                        onAction(ListEvent.OnNavigateToDetails(id))
                    }
                )
            }
        }
        item {
            if ((state as? ListUiState.Success)?.isLoadingMore == true) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(32.dp),
                )
            }
        }
    }
}


@Preview
@Composable
private fun ErrorListScreenPreview() {
    TakeHomeTestTheme {
        ListScreen(
            state = ListUiState.Error(
                message = "Something went wrong"
            ),
            onAction = {}
        )
    }
}

@Preview
@Composable
private fun EmptyScreenPreview() {
    TakeHomeTestTheme {
        ListScreen(
            state = ListUiState.Success(
                items = emptyList()
            ),
            onAction = {}
        )
    }
}

@Preview
@Composable
private fun ListScreenPreview() {
    TakeHomeTestTheme {
        ListScreen(
            state = ListUiState.Success(
                items = listOf(
                    CharacterUi(
                        id = 1,
                        name = "John Doe",
                        image = "https://example.com/image.jpg",
                        status = "Alive",
                        species = "Human",
                    ),
                    CharacterUi(
                        id = 2,
                        name = "John Doe",
                        image = "https://example.com/image.jpg",
                        status = "Alive",
                        species = "Human",
                    ),
                    CharacterUi(
                        id = 3,
                        name = "John Doe",
                        image = "https://example.com/image.jpg",
                        status = "Alive",
                        species = "Human",
                    ),
                )
            ),
            onAction = {}
        )
    }
}