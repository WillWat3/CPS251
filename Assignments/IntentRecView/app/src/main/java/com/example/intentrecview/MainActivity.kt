package com.example.intentrecview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.intentrecview.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private var layoutManager: RecyclerView.LayoutManager? = null
private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
private val mainViewModel = MainViewModel()


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.generateRandom()

        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter(mainViewModel)
        binding.recyclerView.adapter = adapter

    }
}