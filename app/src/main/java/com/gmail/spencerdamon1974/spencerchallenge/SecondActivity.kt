package com.gmail.spencerdamon1974.spencerchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gmail.spencerdamon1974.spencerchallenge.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        supportActionBar?.title = "Marvel Infinity Saga Movie Summary"

        setUpListeners()

        callApi()


    }

    private fun setUpListeners() {

        binding.btnTop.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun secondActivityCallApi() {
        val moviePoster = intent.getStringExtra("poster")
        val movieTitle = intent.getStringExtra("title")
        val moviePlot = intent.getStringExtra("plot")
        val movieGenre = intent.getStringExtra("genre")
        val movieReleased = intent.getStringExtra("released")
        val movieDirector = intent.getStringExtra("director")
        val movieFilmLength = intent.getStringExtra("runtime")
        val movieRating = intent.getStringExtra("rated")
        val movieActors = intent.getStringExtra("actors")
        val movieWriters = intent.getStringExtra("writer")


        if (moviePoster != null) {
            Glide.with(binding.constraintLayout)
                .load(moviePoster)
                .into(binding.ivDetailsPoster)
        }
        if (movieTitle != null) binding.tvDetailsTitle.text = movieTitle
        if (moviePlot != null) binding.tvDetailsSummary.text = moviePlot
        if (movieGenre != null) binding.tvDetailsGenre.text = movieGenre
        if (movieReleased != null) binding.tvDetailsReleased.text = movieReleased
        if (movieDirector != null) binding.tvDetailsDirectedBy.text = movieDirector
        if (movieFilmLength != null) binding.tvDetailsFilmLength.text = movieFilmLength
        if (movieRating != null) binding.tvDetailsRating.text = movieRating
        if (movieActors != null) binding.tvDetailsActors.text = movieActors
        if (movieWriters != null) binding.tvDetailsWriters.text = movieWriters
    }

    private fun callApi() = secondActivityCallApi()
}