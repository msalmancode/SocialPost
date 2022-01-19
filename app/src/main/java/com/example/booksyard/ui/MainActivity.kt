package com.example.booksyard.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksyard.databinding.ActivityMainBinding
import com.example.booksyard.repository.Repository
import com.example.booksyard.ui.adapter.PostAdapter
import com.example.booksyard.viewmodel.MainViewModel
import com.example.booksyard.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    private val adapter: PostAdapter by lazy { PostAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // setup Recycler View
        setUpRecyclerView()

        // setup viewModel
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        // fetching data from API
        viewModel.getPostAll()
        viewModel.myResponseAll.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response isSuccessful ", response.errorBody().toString())

                response.body()?.let { adapter.setData(it) }
//                Log.d("Response", response.body()?.title.toString())
//                Log.d("Response", response.body()?.url.toString())

            } else {
                Log.d("Response Error ", response.errorBody().toString())
            }
        })
    }

    private fun setUpRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}