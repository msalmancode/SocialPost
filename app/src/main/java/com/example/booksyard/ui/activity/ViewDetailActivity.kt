package com.example.booksyard.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.booksyard.R
import com.example.booksyard.databinding.ActivityViewDetailBinding
import com.example.booksyard.model.Post

class ViewDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewDetailBinding
    private var userInfo: Post? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userInfo = intent.getSerializableExtra("post") as Post?

        // setting Data to UI
        Glide.with(this)
            .load(userInfo?.thumbnailUrl + ".png")
            .placeholder(R.drawable.ic_image)
            .into(binding.imageView)

        binding.currentTitle.text = userInfo?.title
        binding.currentDesc.text = userInfo?.url

    }
}