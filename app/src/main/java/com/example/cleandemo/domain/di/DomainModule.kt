package com.example.cleandemo.domain.di

import com.example.cleandemo.domain.repository.UserPostRepo
import com.example.cleandemo.domain.usercase.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideUserUseCase(userPostRepo: UserPostRepo) : UserUseCase = UserUseCase(userPostRepo)
}