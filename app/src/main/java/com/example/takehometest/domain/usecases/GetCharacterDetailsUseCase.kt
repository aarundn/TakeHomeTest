package com.example.takehometest.domain.usecases

import com.example.takehometest.domain.repos.RickAndMortyRepository
import javax.inject.Inject

class GetCharacterDetailsUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(id: Int) = repository.getCharacterById(id)
}