package com.example.takehometest.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.takehometest.presentation.model.CharacterUi
import com.example.takehometest.ui.theme.TakeHomeTestTheme

@Composable
fun DetailsHeader(character: CharacterUi, onBackClick: () -> Unit) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(346.dp)
    ) {
        AsyncImage(
            model = character.image,
            contentDescription = "Character Image",
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.secondary
                ),
            contentScale = ContentScale.Crop
        )
        IconButton(
            modifier = Modifier
                .padding(top = 12.dp, start = 12.dp),
            onClick = onBackClick
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = MaterialTheme.colorScheme.background,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
private fun HeaderPreview() {
    TakeHomeTestTheme {
        DetailsHeader(
            onBackClick = {},
            character = CharacterUi(
                id = 1,
                name = "Test Character",
                image = "https://example.com/image.jpg",
                status = "Alive",
                species = "Human"
            )
        )
    }
}