package com.example.cleandemo.data.repository

import com.example.cleandemo.data.netwrok.ApiService
import com.example.cleandemo.domain.model.User
import com.example.cleandemo.domain.repository.UserPostRepo
import javax.inject.Inject

class UserPostImpl (private val apiService: ApiService):UserPostRepo {
    override suspend fun getUserPost(): List<User> {
        return apiService.getUserPost().map { it.toDomainUser()}
    }
}