package com.example.coroutineprojfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineprojfinal.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private var viewModel = MainViewModel()
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(){
            Log.d("clicked", "please register ffs")
            val name = binding.inputText.text.toString()
            Log.d("CLICKED", name)
            launchCoroutine(name)
        }
    }

    fun launchCoroutine(name:String) {
        GlobalScope.launch(Dispatchers.Main) {
            val rand = (1000L..10000L).random()
            val time = rand / 1000
            delayTime(rand)
            viewModel.addName(name, time)

        }
    }

    private suspend fun delayTime(seconds: Long){
        coroutineScope.async(Dispatchers.Main) {
            delay(timeMillis = seconds)
            layoutManager = LinearLayoutManager(this@MainActivity)
            binding.recyclerView.layoutManager = layoutManager
            adapter = RecyclerAdapter(viewModel.nameList)
            binding.recyclerView.adapter = adapter
        }
    }

}