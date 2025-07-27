package com.example.takehometest.domain.usecases

import com.example.takehometest.domain.repos.RickAndMortyRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
){
    operator fun invoke(page: Int) = repository.getCharacters(page)
}