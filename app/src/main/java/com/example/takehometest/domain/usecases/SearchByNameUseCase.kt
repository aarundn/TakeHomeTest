package com.example.takehometest.domain.usecases

import com.example.takehometest.domain.repos.RickAndMortyRepository
import javax.inject.Inject

class SearchByNameUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    operator fun invoke(name: String) = repository.getCharactersByName(name)
}