package com.example.cleandemo.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.cleandemo.R
import com.example.cleandemo.common.Resource
import com.example.cleandemo.databinding.ActivityMainBinding
import com.example.cleandemo.presentation.viewmodels.UserPostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewmodel:UserPostViewModel by viewModels()
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } */
        binding.viewModel = viewmodel
        binding.lifecycleOwner = this
        viewmodel.getData()

        viewmodel.sateFlow.onEach {
            when(it){
                /*is Resource.Error -> "Error"
                is Resource.Loading -> "Loading"
                is Resource.Success -> Log.e("UserPostViewModel", "getData: ${it.data}", )*/
                is Resource.Error -> Log.e("MainActivity", "Error State")
                is Resource.Loading ->Log.e("MainActivity", "Loading State")
                is Resource.Success -> {
                    Log.e("MainActivity", "${it.data}")
                    it.data?.let { it1 -> viewmodel.userPostAdapter.setData(it1) }
                }
            }
        }
    }


}