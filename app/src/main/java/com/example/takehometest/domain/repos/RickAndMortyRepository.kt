package com.example.takehometest.domain.repos

import kotlinx.coroutines.flow.Flow
import com.example.takehometest.domain.model.Character
interface RickAndMortyRepository {
    fun getCharacters(page: Int): Flow<List<Character>>
    fun getCharactersByName(name: String): Flow<List<Character>>
    suspend fun getCharacterById(id: Int): Character
}