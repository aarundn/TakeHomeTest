package com.example.takehometest.presentation.mapper

import com.example.takehometest.domain.model.Character
import com.example.takehometest.presentation.model.CharacterUi


fun Character.toUiModel(): CharacterUi {
   return CharacterUi(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type
    )
}

fun List<Character>.toUiModel(): List<CharacterUi> {
    return map { it.toUiModel() }
}