package com.noemi.android.mykotlin.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.noemi.android.mykotlin.R
import com.noemi.android.mykotlin.databinding.ItemLayoutBinding
import com.noemi.android.mykotlin.itemlistener.ItemClickListener
import com.noemi.android.mykotlin.model.Item

class ItemAdapter(var context: Context, var listItem: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(), ItemClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding = DataBindingUtil.inflate<ItemLayoutBinding>(LayoutInflater.from(context), R.layout.item_layout, parent, false)
        return ItemViewHolder(binding)

    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listItem[position]
        holder.binding.item = item
        holder.binding.executePendingBindings()
        holder.binding.clickListener = this
    }



    override fun getItemCount(): Int {
        return listItem.size

    }

    override fun onItemClicked(item: Item) {
        Toast.makeText(context, "You clicked on ${item.firstName}", Toast.LENGTH_LONG).show()

    }

    class ItemViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){}

}