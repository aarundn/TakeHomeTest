package com.example.takehometest.data.mapper

import com.example.takehometest.data.remote.model.CharacterDto
import com.example.takehometest.domain.model.Character

fun CharacterDto.toDomainModel(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        image = image
    )
}

fun List<CharacterDto>.toDomainModel(): List<Character> {
    return map { it.toDomainModel() }
}