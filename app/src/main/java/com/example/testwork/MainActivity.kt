package com.example.testwork

import android.app.Activity
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codemobiles.mystock.com.example.testwork.showToast
import com.example.testwork.adapter.CustomListAdapter
import com.example.testwork.databinding.ActivityMainBinding
import com.example.testwork.models.JsonResult
import com.example.testwork.servicoes.APIClient
import com.example.testwork.servicoes.APIServicoes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var customAdapter: CustomListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        customAdapter = CustomListAdapter(null)

        setupWidget()
        feedNetwork()

    }

    private fun feedNetwork() {

         binding.swipeRefresh.isRefreshing = true

         APIClient.getClient().create(APIServicoes::class.java).getDempEvents().let { call ->
             Log.d("cm_network", call.request().url().toString())
             call.enqueue(object :Callback<List<JsonResult>>{
                 override fun onFailure(call: Call<List<JsonResult>>, t: Throwable) {
                     showToast(t.message.toString())
                     binding.swipeRefresh.isRefreshing = false
                 }
                 override fun onResponse(
                     call: Call<List<JsonResult>>,
                     response: Response<List<JsonResult>>
                 ) {
                     if(response.isSuccessful){
                         binding.listRecyclerView.adapter = CustomListAdapter(response.body())
                     }else{
                         showToast(response.message())
                     }
                     binding.swipeRefresh.isRefreshing = false
                 }
             })
         }
    }

    private fun setupWidget() {
        setContentView(binding.root)
        binding.listRecyclerView.apply {
            adapter = customAdapter
            layoutManager = GridLayoutManager(context,2)
        }.also {
            it. addItemDecoration(GridSpacingItemDecoration(2,20,true))
            it.setHasFixedSize(true)
        }
        binding.swipeRefresh.setOnRefreshListener {
            feedNetwork()
        }
    }
}