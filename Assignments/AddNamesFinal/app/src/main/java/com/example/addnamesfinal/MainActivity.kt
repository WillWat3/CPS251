package com.example.addnamesfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.addnamesfinal.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.currentNames.observe(this, Observer {
            binding.nameOutput.text = it.toString()
        })
        binding.addButt.setOnClickListener() {
            if (binding.nameInput.text?.isNotEmpty() == true) {
                viewModel.addName(binding.nameInput.text.toString())
            } else {
                binding.nameOutput.text = "No Name Entered"
            }
            binding.nameInput.text?.clear()
        }

    }

}