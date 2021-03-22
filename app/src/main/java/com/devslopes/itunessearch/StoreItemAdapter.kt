package com.devslopes.itunessearch

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devslopes.itunessearch.databinding.ItemStoreBinding
import com.squareup.picasso.Picasso

class StoreItemAdapter : ListAdapter<ItunesMovieServer.Result, StoreItemAdapter.StoreItemViewHolder>(diff) {

    companion object {
        private val diff = object : DiffUtil.ItemCallback<ItunesMovieServer.Result>() {
            override fun areItemsTheSame(oldItem: ItunesMovieServer.Result, newItem: ItunesMovieServer.Result): Boolean {
                return areContentsTheSame(oldItem, newItem)
            }

            override fun areContentsTheSame(oldItem: ItunesMovieServer.Result, newItem: ItunesMovieServer.Result): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStoreBinding.inflate(inflater, parent, false)
        return StoreItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreItemViewHolder, position: Int) {
        holder.onBind(getItem(position))

        var item = getItem(position)
        var icon = item.artworkUrl100
        Picasso.get().load(icon).into(holder.itemView
            .findViewById<ImageView>(R.id.image))
    }

    class StoreItemViewHolder(
        private val binding: ItemStoreBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(title: ItunesMovieServer.Result) {
            binding.title.text = title.trackName

        }
    }
}