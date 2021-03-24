package com.devslopes.itunessearch

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.devslopes.itunessearch.databinding.ActivityMainBinding
import com.devslopes.itunessearch.repositories.ItunesRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //var selection = radioSelected(binding)

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
        /*
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

        }) */
        /*
        binding.floatingActionButton2.setOnClickListener {
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            fetchMatchingItems(binding,storeItemAdapter)
            Handler().postDelayed(
                    {
                        storeItemAdapter.notifyDataSetChanged()
                    },
                    2000 // value in milliseconds
            )
           // storeItemAdapter.notifyDataSetChanged()

            binding.floatingActionButton2.hide()
            KeyEvent.KEYCODE_ENTER
            binding.search.setOnSearchClickListener{}

        }
*/

        binding.apply {
            results.apply {
                adapter = storeItemAdapter

                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            search.setOnSearchClickListener {
                 search.isSubmitButtonEnabled = true
                search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {

                        fetchMatchingItems(binding, storeItemAdapter)
                        Handler().postDelayed(
                                {
                                    storeItemAdapter.notifyDataSetChanged()
                                },
                                2000 // value in milliseconds
                        )
                        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        search.isSubmitButtonEnabled = true
                        return false
                    }

                })

               // ItunesRepository.moviesServerMutable.clear()
                //storeItemAdapter.notifyDataSetChanged()
               // fetchMatchingItems(binding, storeItemAdapter)
                Handler().postDelayed(
                        {
                            storeItemAdapter.notifyDataSetChanged()
                        },
                        3000 // value in milliseconds
                )
               // storeItemAdapter.submitList(ItunesRepository.moviesTitles)
                //storeItemAdapter.notifyDataSetChanged()
                //ItunesRepository.moviesServerString.clear()
                //storeItemAdapter.notifyDataSetChanged()
               //storeItemAdapter.submitList(ItunesRepository.moviesServerMutable)
                //storeItemAdapter.notifyDataSetChanged()

            }

            filter.setOnCheckedChangeListener { _, _ ->
                //search.setOnSearchClickListener {  }
                //fetchMatchingItems(binding, storeItemAdapter)
                //radioSelected(binding)
               // storeItemAdapter.submitList(ItunesRepository.moviesServerString)
                //storeItemAdapter.notifyDataSetChanged()

            }
        }

    }
    /*
    fun radioSelected(binding:ActivityMainBinding):String{
        var selection =""
         selection = when (binding.filter.checkedRadioButtonId) {
            R.id.movie -> "movie"
            R.id.music -> "music"
            R.id.software -> "software"
            R.id.eBook -> "eBook"
            else -> ""
        }
        return selection
    }
     */

    private fun fetchMatchingItems(binding: ActivityMainBinding, storeItemAdapter: StoreItemAdapter) {
        var searchTerm = binding.search.query.toString()
        val mediaType = when (binding.filter.checkedRadioButtonId) {
            R.id.movie -> "movie"
            R.id.music -> "music"
            R.id.software -> "software"
            R.id.eBook -> "eBook"
            else -> ""
        }

        if (searchTerm.isNotEmpty()) {
            // perform search!!!
            val size: Int = ItunesRepository.moviesServerMutable.size
            ItunesRepository.moviesServerMutable.clear()
            when(mediaType){

                "movie" -> {ItunesRepository.callGetMovie(this,"movie",searchTerm);storeItemAdapter.submitList(ItunesRepository.moviesServerMutable);storeItemAdapter.notifyDataSetChanged()}
                "music" -> {ItunesRepository.callGetMovie(this,"music",searchTerm);storeItemAdapter.submitList(ItunesRepository.moviesServerMutable);storeItemAdapter.notifyDataSetChanged()}
                "software" -> {ItunesRepository.callGetMovie(this,"software",searchTerm);storeItemAdapter.submitList(ItunesRepository.moviesServerMutable);storeItemAdapter.notifyDataSetChanged()}
                "eBook" -> {ItunesRepository.callGetMovie(this,"ebook",searchTerm);storeItemAdapter.submitList(ItunesRepository.moviesServerMutable);storeItemAdapter.notifyDataSetChanged()}
                "else" -> {binding.filter.clearCheck();ItunesRepository.moviesServerMutable.clear();storeItemAdapter.submitList(ItunesRepository.moviesServerMutable);storeItemAdapter.notifyItemRangeRemoved(0, size);storeItemAdapter.notifyDataSetChanged()}

            }
        }else {
            ItunesRepository.moviesServerMutable.clear()
            storeItemAdapter.notifyDataSetChanged()
        }
    }
}
