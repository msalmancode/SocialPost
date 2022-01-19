package com.example.booksyard.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksyard.model.Post
import com.example.booksyard.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponseAll: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getPostAll() {
        viewModelScope.launch {
            val response = repository.getAllPost()
            myResponseAll.value = response
        }
    }

}