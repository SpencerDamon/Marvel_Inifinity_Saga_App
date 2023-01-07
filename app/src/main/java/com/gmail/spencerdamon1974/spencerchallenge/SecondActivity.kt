package com.gmail.spencerdamon1974.spencerchallenge

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gmail.spencerdamon1974.spencerchallenge.data.remote.model.MarvelMovie
import com.gmail.spencerdamon1974.spencerchallenge.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    companion object {
        const val MARVEL = "marvel"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        supportActionBar?.title = "Marvel Infinity Saga Movie Summary"

        setUpListeners()
        setQueryListeners()

        callApi()
    }

    /* Explicit intent to navigate to first activity */
    private fun setUpListeners() {
        binding.btnTop.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    /* Implicit intent to query Google Search for film title */
    private fun setQueryListeners() {
        binding.ivDetailsPoster.setOnClickListener {
            val queryUrl: Uri = Uri.parse("$SEARCH_PREFIX${binding.tvDetailsTitle.text}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            startActivity(intent)
        }
    }

    private fun secondActivityCallApi() {

        val marvelIntent = intent.getParcelableExtra<MarvelMovie>(MARVEL)

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