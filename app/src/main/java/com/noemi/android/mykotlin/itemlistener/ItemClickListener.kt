package com.noemi.android.mykotlin.itemlistener

import com.noemi.android.mykotlin.model.Item

interface ItemClickListener {
    fun onItemClicked(item: Item)
}