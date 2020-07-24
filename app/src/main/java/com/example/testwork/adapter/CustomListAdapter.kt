package com.example.testwork.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testwork.databinding.ActivityLitsBinding

class CustomListAdapter(var productList: ArrayList<String>?): RecyclerView.Adapter<CustomListAdapter.ViewHolder>(){

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomListAdapter.ViewHolder {
      val binding = ActivityLitsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root, binding)
    }

    override fun getItemCount() = productList?.size ?: 0

    override fun onBindViewHolder(holder: CustomListAdapter.ViewHolder, position: Int) {
       val binding = holder.binding

        binding.textviewName.text = "aaaa"
        binding.textviewDetail.text = "bbbb"

    }

    inner class ViewHolder(view: View,val binding:ActivityLitsBinding):RecyclerView.ViewHolder(view){

    }

}