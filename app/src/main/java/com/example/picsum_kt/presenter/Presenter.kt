package com.example.picsum_kt.presenter

import android.util.Log
import com.example.picsum_kt.model.Picsum
import com.example.picsum_kt.model.PicsumApi
import com.example.picsum_kt.view.ViewContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Presenter: PresenterContract {

    companion object {
        private const val BASE_URL = "https://picsum.photos/"
    }

    private lateinit var api: PicsumApi
    private lateinit var viewContract: ViewContract

    override fun bindView(view: ViewContract) {
        this.viewContract = view
    }

    override fun initializeRetrofit() {

        val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        api = retrofit.create(PicsumApi::class.java)
    }

    override fun getPicsums() {

        api.getPicsum().enqueue(object: Callback<List<Picsum>>{
            override fun onResponse(call: Call<List<Picsum>>, response: Response<List<Picsum>>) {
                viewContract.addPicsum(response.body()!!)
            }

            override fun onFailure(call: Call<List<Picsum>>, t: Throwable) {
                Log.d("Presenter: ", "onFailure: Something went wrong!")
            }
        })

    }
}