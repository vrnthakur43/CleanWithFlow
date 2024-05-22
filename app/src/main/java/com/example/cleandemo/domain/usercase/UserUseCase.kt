package com.example.cleandemo.domain.usercase

import com.example.cleandemo.common.Resource
import com.example.cleandemo.domain.model.User
import com.example.cleandemo.domain.repository.UserPostRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserUseCase (private val userPostRepo: UserPostRepo) {
    operator fun invoke(): Flow<Resource<List<User>>> = flow<Resource<List<User>>>{
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = userPostRepo.getUserPost()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message))
        }
    }.flowOn(Dispatchers.IO)
}