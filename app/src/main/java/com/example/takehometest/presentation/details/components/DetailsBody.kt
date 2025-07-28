package com.example.takehometest.presentation.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.takehometest.R
import com.example.takehometest.presentation.comon.components.StatusLabel
import com.example.takehometest.presentation.model.CharacterUi
import com.example.takehometest.ui.theme.TakeHomeTestTheme

@Composable
fun DetailsBody(character: CharacterUi) {
    Column (
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(start = 16.dp)
    ){
        Row {
            Text(
                text = character.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            StatusLabel(character.status)
        }
        Text(
            text = character.species,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.lorem_text),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(end = 16.dp)
        )
    }
}



@Preview(showBackground = true)
@Composable
private fun BodyPreview() {
    TakeHomeTestTheme {
        DetailsBody(
            character = CharacterUi(
                id = 1,
                name = "Rick Sanchez",
                status = "Alive",
                species = "Human",
                image = "https://example.com/image.jpg"
               ),
        )
    }
}