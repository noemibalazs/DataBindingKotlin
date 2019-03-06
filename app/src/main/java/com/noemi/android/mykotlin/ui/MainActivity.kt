package com.noemi.android.mykotlin.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.noemi.android.mykotlin.R
import com.noemi.android.mykotlin.adapter.ItemAdapter

import com.noemi.android.mykotlin.model.ItemList
import com.noemi.android.mykotlin.network.ApiClient
import com.noemi.android.mykotlin.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private var recycleview: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleview = findViewById(R.id.recycle_view)
        recycleview!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycleview!!.setHasFixedSize(true)

        val retrofit = ApiClient.getInstance().create(ApiInterface::class.java)
        val itemList = retrofit.getListItems()
        itemList.enqueue(object : Callback<ItemList> {


            override fun onResponse(call: Call<ItemList>, response: Response<ItemList>) {
                if (!response.isSuccessful) {
                    Log.d("TAG", "onResponse: " + response.code());
                }

                if (response.body() != null) {
                    val items = response.body()!!.getListItem
                    val myAdapter = ItemAdapter(applicationContext, items)
                    recycleview!!.adapter = myAdapter



                }

            }

            override fun onFailure(call: Call<ItemList>, t: Throwable) {
                Toast.makeText(this@MainActivity, getString(R.string.toast), Toast.LENGTH_SHORT).show();
                Log.e("TAG", "Error")
            }
        })


    }
}
