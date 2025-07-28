package com.example.takehometest.presentation.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.takehometest.presentation.list.ListEvent.OnShowToast
import com.example.takehometest.presentation.list.components.EmptyListScreen
import com.example.takehometest.presentation.list.components.ListHeader
import com.example.takehometest.presentation.list.components.ListItems
import com.example.takehometest.presentation.list.components.SearchBar
import com.example.takehometest.presentation.model.CharacterUi
import com.example.takehometest.ui.theme.TakeHomeTestTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    onAction: (ListEvent) -> Unit,
    state: ListUiState,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {
                    SearchBar(
                        onAction = onAction,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            )
        },
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {

            when (state) {

                is ListUiState.Loading -> LoadingIndicator(modifier = Modifier.fillMaxSize())

                is ListUiState.Error -> onAction(OnShowToast(state.message))

                is ListUiState.Success -> {
                    ListContent(
                        characters = state.items,
                        onAction = onAction,
                        state = state,
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
    val state = state as ListUiState.Success

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