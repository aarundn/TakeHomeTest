package com.example.takehometest.data.remote.model

import kotlinx.serialization.Serializable

@Serializable


data class CharacterResponse (
    val info: Info,
    val results: List<CharacterDto>
)


