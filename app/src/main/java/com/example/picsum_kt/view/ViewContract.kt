package com.example.picsum_kt.view

import com.example.picsum_kt.model.Picsum

interface ViewContract {

    fun addPicsum(dataSet: List<Picsum>)
    fun onError(errorMessage: String)
}