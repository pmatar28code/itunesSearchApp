package com.devslopes.itunessearch

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.devslopes.itunessearch.databinding.ActivityMainBinding
import com.devslopes.itunessearch.repositories.ItunesRepository

class MainActivity : AppCompatActivity() {
    var context = this
    var newStoreItemAdapter = StoreItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val storeItemAdapter = StoreItemAdapter()

        binding.apply {
            results.apply {
                adapter = storeItemAdapter

                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            search.setOnSearchClickListener {
                 search.isSubmitButtonEnabled = true
                search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        //this next two lines are the ones that call asynctaskcomment this next two
                        // lines and un uncomment fetchMatchingItmens(binding,storeItemAdapter)
                        // which is the next commented line to make it work
                        //var longRunning = longRunningTask()
                        //longRunning.execute()
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
            }

            filter.setOnCheckedChangeListener { _, _ ->

            }
        }
    }
    //uncomment lines inside doInBackground OR uncomment lines inside onPostExecute
    private class longRunningTask():AsyncTask<Void,Void,String>(){
        override fun doInBackground(vararg p0: Void?): String {
            //var inflater = LayoutInflater.from(MainActivity().context)
           //var binding = ActivityMainBinding.inflate(inflater)
           // MainActivity().fetchMatchingItems( binding,MainActivity().newStoreItemAdapter)
            //  Toast.makeText(MainActivity().context,"This is AsycTask",Toast.LENGTH_LONG).show()
           return "test"
       }

        override fun onPostExecute(result: String?) {
           // var inflater = LayoutInflater.from(MainActivity().context)
            // var binding = ActivityMainBinding.inflate(inflater)
             //MainActivity().fetchMatchingItems( MainActivity().newStoreItemAdapter)
        }
    }

    private fun fetchMatchingItems(binding : ActivityMainBinding, storeItemAdapter : StoreItemAdapter) {
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
                "movie" -> {
                    ItunesRepository.callGetMovie(this,"movie",searchTerm);
                    storeItemAdapter.submitList(ItunesRepository.moviesServerMutable);
                    storeItemAdapter.notifyDataSetChanged()
                }
                "music" -> {
                    ItunesRepository.callGetMovie(this,"music",searchTerm);
                    storeItemAdapter.submitList(ItunesRepository.moviesServerMutable);
                    storeItemAdapter.notifyDataSetChanged()
                }
                "software" -> {
                    ItunesRepository.callGetMovie(this,"software",searchTerm);
                    storeItemAdapter.submitList(ItunesRepository.moviesServerMutable);
                    storeItemAdapter.notifyDataSetChanged()
                }
                "eBook" -> {
                    ItunesRepository.callGetMovie(this,"ebook",searchTerm);
                    storeItemAdapter.submitList(ItunesRepository.moviesServerMutable);
                    storeItemAdapter.notifyDataSetChanged()
                }
                "else" -> {
                    binding.filter.clearCheck();
                    ItunesRepository.moviesServerMutable.clear();
                    storeItemAdapter.submitList(ItunesRepository.moviesServerMutable);
                    storeItemAdapter.notifyItemRangeRemoved(0, size);
                    storeItemAdapter.notifyDataSetChanged()
                }
            }
        } else {
            ItunesRepository.moviesServerMutable.clear()
            storeItemAdapter.notifyDataSetChanged()
        }
    }
}

