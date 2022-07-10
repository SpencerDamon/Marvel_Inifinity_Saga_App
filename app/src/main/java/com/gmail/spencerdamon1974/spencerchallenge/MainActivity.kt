package com.gmail.spencerdamon1974.spencerchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gmail.spencerdamon1974.spencerchallenge.data.remote.repository.MarvelMovieRepository
import com.gmail.spencerdamon1974.spencerchallenge.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val marvelMovieRepository = MarvelMovieRepository()
    private lateinit var marvelAdapter: MarvelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val marvelMovies = marvelMovieRepository.getMarvelMovies().toList()
            //marvelAdapter = MarvelAdapter(marvelMovies)
            Log.d("Movies", marvelMovies.toString())
        }
    }
}