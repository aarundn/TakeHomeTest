package com.example.takehometest.presentation.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.takehometest.R
import com.example.takehometest.presentation.list.ListEvent
import com.example.takehometest.ui.theme.TakeHomeTestTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onAction: (ListEvent) -> Unit
) {
    val input = remember { mutableStateOf("") }

    BasicTextField(
        value = input.value,
        onValueChange = {
            onAction(ListEvent.OnSearch(it))
            input.value = it
        },
        maxLines = 1,
        modifier = modifier
            .height(48.dp),
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            color = MaterialTheme.colorScheme.onBackground
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        shape = RoundedCornerShape(26.dp)
                    )
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = MaterialTheme.colorScheme.onSecondaryContainer,
                    )
                }
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    if (input.value.isEmpty())
                        Text(
                            text = stringResource(R.string.search_by_name),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            ),
                            overflow = TextOverflow.Ellipsis,
                        )
                    innerTextField()
                }

            }
        },
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary)
    )
}


@Preview
@Composable
private fun SearchBarPreview() {
    TakeHomeTestTheme {
        SearchBar (
            onAction = {}
        )
    }
}