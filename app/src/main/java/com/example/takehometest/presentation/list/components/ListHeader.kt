package com.example.takehometest.presentation.list.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.takehometest.R


@Composable
fun ListHeader() {
    Text(
        text = stringResource(R.string.rick_and_morty_characters),
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.padding(start = 16.dp, top = 16.dp)
    )
}