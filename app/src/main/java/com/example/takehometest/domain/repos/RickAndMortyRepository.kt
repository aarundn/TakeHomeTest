package com.example.takehometest.domain.repos

import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun getCharacters(page: Int): Flow<List<Character>>
    fun getCharactersByName(name: String): Flow<List<Character>>
    fun getCharacterById(id: Int): Flow<Character>
}