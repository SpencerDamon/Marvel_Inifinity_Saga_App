package com.gmail.spencerdamon1974.spencerchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gmail.spencerdamon1974.spencerchallenge.data.remote.model.MarvelMovie
import com.gmail.spencerdamon1974.spencerchallenge.databinding.ActivitySecondBinding
import java.lang.System.load

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpListeners()

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

    private fun setUpListeners() {
        //val movie = MarvelResponse()
        binding.btnTop.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnBottom.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
//    fun bind(marvelMovie: MarvelMovie) {
//        with(binding) {
//            Glide.with(binding.root)
//                .load(marvelMovie.poster) //(marvelMovie.poster.jpg)
//                .into(binding.ivPoster)
//            tvMovieGenre.text = marvelMovie.genre //.movieGenre
//            tvMovieName.text = marvelMovie.title //.movieTitle
//            tvReleasedDate.text = marvelMovie.released //.movieReleased

}