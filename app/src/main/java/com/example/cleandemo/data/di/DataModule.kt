package com.example.cleandemo.data.di

import com.example.cleandemo.data.netwrok.ApiService
import com.example.cleandemo.data.repository.UserPostImpl
import com.example.cleandemo.domain.repository.UserPostRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserPostImpl(apiService: ApiService): UserPostRepo {
        return UserPostImpl(apiService)
    }
}