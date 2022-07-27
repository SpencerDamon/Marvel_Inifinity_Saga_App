package com.gmail.spencerdamon1974.spencerchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gmail.spencerdamon1974.spencerchallenge.data.remote.model.MarvelMovie
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

        val marvelIntent = intent.getParcelableExtra<MarvelMovie>("marvel")

        if (marvelIntent != null) {
            Glide.with(binding.constraintLayout)
                .load(marvelIntent.poster)
                .into(binding.ivDetailsPoster)

            binding.tvDetailsTitle.text = marvelIntent.title
            binding.tvDetailsSummary.text = marvelIntent.plot
            binding.tvDetailsGenre.text = marvelIntent.genre
            binding.tvDetailsReleased.text = marvelIntent.released
            binding.tvDetailsDirectedBy.text = marvelIntent.director
            binding.tvDetailsFilmLength.text = marvelIntent.runtime
            binding.tvDetailsRating.text = marvelIntent.rated
            binding.tvDetailsActors.text = marvelIntent.actors
            binding.tvDetailsWriters.text = marvelIntent.writer
        }
    }

    private fun callApi() = secondActivityCallApi()
}