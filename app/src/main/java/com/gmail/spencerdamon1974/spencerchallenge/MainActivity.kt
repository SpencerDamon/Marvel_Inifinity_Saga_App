package com.gmail.spencerdamon1974.spencerchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.gmail.spencerdamon1974.spencerchallenge.data.remote.repository.MarvelMovieRepository
import com.gmail.spencerdamon1974.spencerchallenge.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val marvelMovieRepository = MarvelMovieRepository()
    private lateinit var marvelAdapter: MarvelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupLoadingState()
        CoroutineScope(Dispatchers.IO).launch {
            val marvelMovies = marvelMovieRepository.getMarvelMovies().toList()
            marvelAdapter = MarvelAdapter(marvelMovies)
            Log.d("Movies", marvelMovies.toString())
            withContext(Dispatchers.Main) {
                setupRecyclerView()
                setupSuccessState()
            }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerview.adapter = marvelAdapter
    }

    private fun setupSuccessState() = with(binding) {
        recyclerview.isVisible = true
        progressLoading.isVisible = false
    }


    private fun setupLoadingState() = with(binding) {
        recyclerview.isVisible = false
        progressLoading.isVisible = true
    }
}