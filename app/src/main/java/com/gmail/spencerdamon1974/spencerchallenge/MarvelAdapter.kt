package com.gmail.spencerdamon1974.spencerchallenge

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gmail.spencerdamon1974.spencerchallenge.data.remote.model.MarvelMovie
import com.gmail.spencerdamon1974.spencerchallenge.databinding.ItemMarvelMovieListBinding

class MarvelAdapter(private val marvelMovieList: List<MarvelMovie>) : RecyclerView.Adapter<MarvelAdapter.MarvelViewHolder>(){

    inner class MarvelViewHolder(private val binding: ItemMarvelMovieListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(marvelMovie: MarvelMovie) {
            with(binding) {
                Glide.with(binding.root)
                    .load(marvelMovie.poster) //(marvelMovie.poster.jpg)
                    .into(binding.ivPoster)
                tvMovieGenre.text = marvelMovie.genre //.movieGenre
                tvMovieName.text = marvelMovie.title //.movieTitle
                tvReleasedDate.text = marvelMovie.released //.movieReleased

                binding.root.setOnClickListener {
                    val intent = Intent(binding.root.context, SecondActivity::class.java)
                    intent.putExtra("marvel", marvelMovie)
                    binding.root.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelViewHolder {
        val binding = ItemMarvelMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarvelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        holder.bind(marvelMovieList[position])
    }

    override fun getItemCount(): Int {
        return marvelMovieList.size
    }
}