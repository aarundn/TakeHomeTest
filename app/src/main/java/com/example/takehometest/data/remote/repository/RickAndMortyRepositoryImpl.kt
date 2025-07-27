package com.example.takehometest.data.remote.repository

import com.example.takehometest.data.mapper.toDomainModel
import com.example.takehometest.data.remote.model.CharacterResponse
import com.example.takehometest.di.RICK_AND_MORTY_BASE_URL
import com.example.takehometest.domain.repos.RickAndMortyRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.example.takehometest.domain.model.Character

class RickAndMortyRepositoryImpl @Inject constructor(
    val ktorClient: HttpClient
) : RickAndMortyRepository {

    override fun getCharacters(page: Int): Flow<List<Character>> = flow {

        val characters = ktorClient.get("${RICK_AND_MORTY_BASE_URL}/character?page=$page")
            .body<CharacterResponse>().results.toDomainModel()
        emit(characters)

    }

    override fun getCharactersByName(name: String): Flow<List<Character>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterById(id: Int): Character {
        TODO("Not yet implemented")
    }
}