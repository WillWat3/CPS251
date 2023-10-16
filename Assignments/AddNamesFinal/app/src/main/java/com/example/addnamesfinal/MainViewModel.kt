package com.example.addnamesfinal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val currentNames: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    fun addName(name: String){
        currentNames.value += name + "\n"
    }

}