package com.example.picsum_kt.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.picsum_kt.R
import com.example.picsum_kt.model.Picsum
import com.example.picsum_kt.presenter.PicsumAdapter
import com.example.picsum_kt.presenter.Presenter
import com.example.picsum_kt.presenter.PresenterContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewContract {

    private lateinit var presenter: PresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager

        presenter = Presenter()
        presenter.bindView(this)
        presenter.initializeRetrofit()
        presenter.getPicsums()
    }

    override fun addPicsum(dataSet: List<Picsum>) {
        recyclerview.adapter = PicsumAdapter(dataSet)
    }

    override fun onError(errorMessage: String) {
        Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
    }
}
