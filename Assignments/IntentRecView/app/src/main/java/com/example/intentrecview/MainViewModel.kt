package com.example.intentrecview

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var hasRan = false
    private var permTitle = ""
    private var permDetail = ""
    private var permImage = 0

    fun generateRandom(){
        if(!hasRan){
            val myData = Data("")
            val ranInt = (0..7).random()

            permTitle = myData.titles[ranInt]
            permDetail = myData.details[ranInt]
            permImage = myData.images[ranInt]

            hasRan = true
        }
    }

    fun getTitle(): String {
        return permTitle
    }


    fun getDetail(): String {
        return permDetail
    }


    fun getImage(): Int{
        return permImage
    }
}