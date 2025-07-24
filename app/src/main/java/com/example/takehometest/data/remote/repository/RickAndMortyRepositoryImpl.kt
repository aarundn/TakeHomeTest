package com.example.takehometest.data.remote.repository

import com.example.takehometest.domain.repos.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
class RickAndMortyRepositoryImpl @Inject constructor(

): RickAndMortyRepository {
    override fun getCharacters(page: Int): Flow<List<Character>> {
        TODO("Not yet implemented")
    }

    override fun getCharactersByName(name: String): Flow<List<Character>> {
        TODO("Not yet implemented")
    }

    override fun getCharacterById(id: Int): Flow<Character> {
        TODO("Not yet implemented")
    }
}