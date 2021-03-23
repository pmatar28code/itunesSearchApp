package com.devslopes.itunessearch

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
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

        binding.search.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                binding.test.text = "again"
                var searchFabButton = binding.floatingActionButton2
                searchFabButton.hide()
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                binding.test.text = "pedro"
                var searchFabButtonShow = binding.floatingActionButton2
                searchFabButtonShow.show()
                return true
            }

        })

        binding.floatingActionButton2.setOnClickListener {
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            fetchMatchingItems(binding,storeItemAdapter)
            Handler().postDelayed(
                    {
                        storeItemAdapter.notifyDataSetChanged()                    },
                    2000 // value in milliseconds
            )
           // storeItemAdapter.notifyDataSetChanged()

            binding.floatingActionButton2.hide()
            KeyEvent.KEYCODE_ENTER
            binding.search.setOnSearchClickListener{}

        }


        binding.apply {
            results.apply {
                adapter = storeItemAdapter

                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            search.setOnSearchClickListener {
               // ItunesRepository.moviesServerMutable.clear()
                //storeItemAdapter.notifyDataSetChanged()
                //fetchMatchingItems(binding, storeItemAdapter)

               // storeItemAdapter.submitList(ItunesRepository.moviesTitles)
                //storeItemAdapter.notifyDataSetChanged()
                //ItunesRepository.moviesServerString.clear()
                //storeItemAdapter.notifyDataSetChanged()
               //storeItemAdapter.submitList(ItunesRepository.moviesServerMutable)
                //storeItemAdapter.notifyDataSetChanged()

            }

            filter.setOnCheckedChangeListener { _, _ ->
               // fetchMatchingItems(binding, storeItemAdapter)

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

                "movie" -> {ItunesRepository.callGetMovie(this,"movie",searchTerm);storeItemAdapter.submitList(ItunesRepository.moviesServerMutable);storeItemAdapter.notifyDataSetChanged()}

            }



        }
    }
}
