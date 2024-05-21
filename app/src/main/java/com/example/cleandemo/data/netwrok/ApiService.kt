package com.example.cleandemo.data.netwrok

import com.example.cleandemo.data.model.UserDTO
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
   suspend fun getUserPost():List<UserDTO>
}