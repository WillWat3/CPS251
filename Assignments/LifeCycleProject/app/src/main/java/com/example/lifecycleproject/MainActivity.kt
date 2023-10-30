package com.example.lifecycleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleproject.databinding.ActivityMainBinding
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
    private var time = LocalTime.now().format(formatter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        time = LocalTime.now().format(formatter)
        viewModel.updateText("onCreate was fired on $time \n")
        viewModel.outText.observe(this, Observer {
            binding.outBox.text = it.toString()
        })
    }

    override fun onStart() {
        super.onStart()
        time = LocalTime.now().format(formatter)
        viewModel.updateText("onStart was fired on $time \n")
    }

    override fun onResume() {
        super.onResume()
        time = LocalTime.now().format(formatter)
        viewModel.updateText("onResume was fired on $time \n")
        viewModel.updateText("******************************\n")
    }

    override fun onPause() {
        super.onPause()
        time = LocalTime.now().format(formatter)
        viewModel.updateText("onPause was fired on $time \n")
        viewModel.updateText("******************************\n")
    }

    override fun onStop() {
        super.onStop()
        time = LocalTime.now().format(formatter)
        viewModel.updateText("onStop was fired on $time \n")
    }

    override fun onDestroy() {
        super.onDestroy()
        time = LocalTime.now().format(formatter)
        viewModel.updateText("onDestroy was fired on $time \n")
        viewModel.updateText("******************************\n")
    }

}