package com.example.booksyard.repository

import com.example.booksyard.api.RetrofitInstance
import com.example.booksyard.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number:Int): Response<Post> {
        return RetrofitInstance.api.getPost(number)
    }

    suspend fun getAllPost(): Response<List<Post>> {
        return RetrofitInstance.api.getAllPost()
    }
}