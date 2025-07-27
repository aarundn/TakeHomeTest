package com.example.takehometest.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val id: String,
    val name: String,
    val status: String,
    val image: String,
    val species: String,
)