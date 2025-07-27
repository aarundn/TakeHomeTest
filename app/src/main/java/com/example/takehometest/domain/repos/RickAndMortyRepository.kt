package com.example.takehometest.domain.repos

import kotlinx.coroutines.flow.Flow
import com.example.takehometest.domain.model.Character
import com.example.takehometest.domain.model.CharacterPageResult

interface RickAndMortyRepository {
    fun getCharacters(page: Int): Flow<CharacterPageResult>
    fun getCharactersByName(name: String): Flow<List<Character>>
    suspend fun getCharacterById(id: Int): Character
}