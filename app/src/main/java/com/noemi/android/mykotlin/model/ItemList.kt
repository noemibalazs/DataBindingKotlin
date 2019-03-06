package com.noemi.android.mykotlin.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class ItemList{
        @field:SerializedName("data")
        val getListItem: List<Item> = listOf()
}
