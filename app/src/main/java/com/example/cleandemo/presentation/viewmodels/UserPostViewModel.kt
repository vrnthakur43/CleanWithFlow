package com.example.cleandemo.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleandemo.common.Resource
import com.example.cleandemo.domain.model.User
import com.example.cleandemo.domain.usercase.UserUseCase
import com.example.cleandemo.presentation.UserPostAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserPostViewModel @Inject constructor(val userUseCase: UserUseCase) : ViewModel() {

    val userPostAdapter = UserPostAdapter()

    private var _userSateFlow = MutableStateFlow<Resource<List<User>>>(Resource.Loading())
    val sateFlow: StateFlow<Resource<List<User>>> get() = _userSateFlow

    fun getData() {
        userUseCase().onEach {
            _userSateFlow.value = it
            Log.e("usecase", "getData: ${it.data}", )
        }.launchIn(viewModelScope)


       /* viewModelScope.launch {
            userUseCase.invoke().collect {
                _userSateFlow.value = it
            }
        }*/

    }
}