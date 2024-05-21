package com.example.cleandemo.data.model

import com.example.cleandemo.domain.model.User

data class UserDTO(val userId: String?, val id: String?, val title: String?, val body: String?) {

    fun toDomainUser(): User {
        return User(userId ?: "", id = id ?: "", title = title ?: "", body = body ?: "")
    }

}
