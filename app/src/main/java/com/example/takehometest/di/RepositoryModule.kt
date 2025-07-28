package com.example.takehometest.di

import com.example.takehometest.data.remote.repository.RickAndMortyRepositoryImpl
import com.example.takehometest.domain.repos.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCharacterRepository(
        impl: RickAndMortyRepositoryImpl
    ): RickAndMortyRepository
}