package com.example.takehometest.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

@SerialName("characters")
data class CharacterResponse (
    @SerialName("info")
    val info: Info,
    @SerialName("results")
    val results: List<CharacterDto>
)


