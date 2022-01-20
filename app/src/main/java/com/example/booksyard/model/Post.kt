package com.example.booksyard.model

import java.io.Serializable

data class Post(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
) : Serializable