package com.example.cleandemo.domain.repository

import com.example.cleandemo.domain.model.User

interface UserPostRepo {
   suspend fun getUserPost():List<User>
}