package com.devslopes.itunessearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import com.devslopes.itunessearch.databinding.ActivityMainBinding
import com.devslopes.itunessearch.repositories.ItunesRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val storeItemAdapter = StoreItemAdapter()
       // ItunesRepository.callGetMovie(this,"movie","toy story")

        Handler().postDelayed(
            {
               // binding.test.text = ItunesRepository?.moviesServer?.get(0)?.trackName?:"test"
                //binding.test.text = ItunesRepository.movieObj?.trackName
                binding.test.text = ItunesRepository?.moviesServer?.get(0)?.trackName?:"test"
            },
            1000 // value in milliseconds
        )


        binding.apply {
            results.apply {
                adapter = storeItemAdapter

                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            search.setOnSearchClickListener { 
                fetchMatchingItems(binding, storeItemAdapter)
               // storeItemAdapter.submitList(ItunesRepository.moviesTitles)
                //storeItemAdapter.notifyDataSetChanged()
                ItunesRepository.moviesServerString.clear()
                storeItemAdapter.notifyDataSetChanged()
               storeItemAdapter.submitList(ItunesRepository.moviesServerMutable)
                storeItemAdapter.notifyDataSetChanged()

            }

            filter.setOnCheckedChangeListener { _, _ ->
                fetchMatchingItems(binding, storeItemAdapter)
               // storeItemAdapter.submitList(ItunesRepository.moviesServerString)
               // storeItemAdapter.notifyDataSetChanged()

            }
        }

    }

    private fun fetchMatchingItems(binding: ActivityMainBinding, storeItemAdapter: StoreItemAdapter) {
        val searchTerm = binding.search.query.toString()
        val mediaType = when (binding.filter.checkedRadioButtonId) {
            R.id.movie -> "movie"
            R.id.music -> "music"
            R.id.software -> "software"
            R.id.eBook -> "eBook"
            else -> ""
        }

        if (searchTerm.isNotEmpty()) {
            // perform search!!!
            ItunesRepository.moviesServerMutable.clear()
            when(mediaType){
                "movie" -> ItunesRepository.callGetMovie(this,"movie",searchTerm)
            }


        }
    }
}
