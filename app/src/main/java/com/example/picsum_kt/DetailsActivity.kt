package com.example.picsum_kt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.picsum_kt.model.Picsum
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val IMAGE_URL = "https://picsum.photos/400/400?image="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent = intent
        val picsum = intent.getParcelableExtra<Picsum>("picsum")

        Picasso.get().load(IMAGE_URL + picsum.id).into(iv_author_img)
        tv_format.text = "Format: ${picsum.format}"
        tv_width.text = "Width: ${picsum.width}"
        tv_height.text = "Height: ${picsum.height}"
        tv_filename.text = "File name: ${picsum.filename}"
        tv_author.text = "Author: ${picsum.author}"
        tv_author_url.text = "Author url: ${picsum.author_url}"
        tv_post_url.text = "Post url: ${picsum.post_url}"
    }
}
