package com.example.picsum_kt.presenter

import com.example.picsum_kt.view.ViewContract

interface PresenterContract {

    fun bindView(view: ViewContract)
    fun initializeRetrofit()
    fun getPicsums()
}
