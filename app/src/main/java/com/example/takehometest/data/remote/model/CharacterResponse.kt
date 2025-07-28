package com.example.takehometest.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable


@SerialName("character")
data class CharacterResponse (
    val info: Info,
    @SerialName("results")
    val results: List<CharacterDto>
)


