package com.noemi.android.mykotlin.model
import com.google.gson.annotations.SerializedName


class Item (
        @field:SerializedName("id") val id: Int,
        @field:SerializedName("first_name")val firstName: String,
        @field:SerializedName("last_name")val lastName: String,
        @field:SerializedName("avatar")val url: String){
}