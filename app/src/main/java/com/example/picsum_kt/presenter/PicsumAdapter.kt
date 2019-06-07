package com.example.picsum_kt.presenter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.picsum_kt.DetailsActivity
import com.example.picsum_kt.R
import com.example.picsum_kt.model.Picsum
import com.squareup.picasso.Picasso

class PicsumAdapter(private var dataSet: List<Picsum>): RecyclerView.Adapter<PicsumAdapter.PicsumViewHolder>() {

    companion object {
        const val IMAGE_URL = "https://picsum.photos/400/300?image="
    }

    //var dataSet: List<Picsum> = dataSet
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PicsumAdapter.PicsumViewHolder {
        context = parent.context
        return PicsumViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.item_layout, parent, false))

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(picsumViewHolder: PicsumAdapter.PicsumViewHolder, position: Int) {
        val id = dataSet[position].id
        Picasso.get().load(IMAGE_URL + id).into(picsumViewHolder.image)
        picsumViewHolder.tvAuthor.text = dataSet[position].author

        picsumViewHolder.cardView.setOnClickListener {

            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("picsum", dataSet[position])

            context.startActivity(intent)
        }
    }

    inner class PicsumViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.iv_img)
        var tvAuthor: TextView
        var cardView: CardView

        init {
            tvAuthor = itemView.findViewById(R.id.tv_author)
            cardView = itemView.findViewById(R.id.cardview)
        }

    }
}