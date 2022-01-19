package com.example.booksyard.api

import com.example.booksyard.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {

    @GET("/photos/1")
    suspend fun getPost(): Response<Post>

    @GET("/photos/{postNumber}")
    suspend fun getPost(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("/photos")
    suspend fun getAllPost(): Response<List<Post>>
}