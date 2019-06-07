package com.example.picsum_kt.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Picsum (@SerializedName("format")val format: String,
                   val width: String,
                   val height: String, val filename: String,
                   val id: String, val author: String,
                   val author_url: String, val post_url: String): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(format)
        parcel.writeString(width)
        parcel.writeString(height)
        parcel.writeString(filename)
        parcel.writeString(id)
        parcel.writeString(author)
        parcel.writeString(author_url)
        parcel.writeString(post_url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Picsum> {
        override fun createFromParcel(parcel: Parcel): Picsum {
            return Picsum(parcel)
        }

        override fun newArray(size: Int): Array<Picsum?> {
            return arrayOfNulls(size)
        }
    }

}