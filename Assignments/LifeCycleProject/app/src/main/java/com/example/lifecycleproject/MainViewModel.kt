package com.example.lifecycleproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val outText = MutableLiveData<String>("")

    fun updateText(text: String){
        outText.value += text
    }
}