package com.example.takehometest.data.remote.repository

import com.example.takehometest.data.mapper.toDomainModel
import com.example.takehometest.data.remote.model.CharacterDto
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
import com.example.takehometest.domain.model.CharacterPageResult

class RickAndMortyRepositoryImpl @Inject constructor(
    val ktorClient: HttpClient
) : RickAndMortyRepository {

    override fun getCharacters(page: Int): Flow<CharacterPageResult> = flow {

        val characters = ktorClient.get("${RICK_AND_MORTY_BASE_URL}/character?page=$page")
            .body<CharacterResponse>()
        emit(
            CharacterPageResult(
                characters = characters.results.toDomainModel(),
                totalPages = characters.info.pages
            )
        )

    }


    override fun getCharactersByName(name: String): Flow<List<Character>> = flow {
        val characters = ktorClient.get("${RICK_AND_MORTY_BASE_URL}/character?name=$name")
            .body<CharacterResponse>()
        emit(characters.results.toDomainModel())
    }


    override suspend fun getCharacterById(id: Int): Character {
        val character = ktorClient.get("${RICK_AND_MORTY_BASE_URL}/character/$id")
            .body<CharacterDto>()
        return character.toDomainModel()
    }
}