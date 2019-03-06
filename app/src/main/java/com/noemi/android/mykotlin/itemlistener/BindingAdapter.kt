package com.noemi.android.mykotlin.itemlistener

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.noemi.android.mykotlin.R
import com.noemi.android.mykotlin.adapter.CircleAdapter
import com.squareup.picasso.Picasso

class BindingAdapter{

    companion object {
        @BindingAdapter("android:src")
        @JvmStatic
        fun setImageUrl(view: ImageView, string: String){
            Picasso.get()
                    .load(string)
                    .transform(CircleAdapter())
                    .error(R.drawable.anonymus)
                    .placeholder(R.drawable.anonymus)
                    .into(view)
        }
    }

}