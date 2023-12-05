package com.example.coroutineprojfinal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
        var nameList: MutableList<String> = ArrayList()

    fun addName(name:String, delay: Long){
        nameList.add("The name is $name and the delay was $delay seconds")

    }

}