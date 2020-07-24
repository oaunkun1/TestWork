package com.example.testwork.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testwork.Proflie
import com.example.testwork.R
import com.example.testwork.databinding.ActivityLitsBinding
import com.example.testwork.models.JsonResult

class CustomListAdapter(private var productList: List<JsonResult>?): RecyclerView.Adapter<CustomListAdapter.ViewHolder>(){

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomListAdapter.ViewHolder {
      val binding = ActivityLitsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root, binding)
    }

    override fun getItemCount() = productList?.size ?: 0

    override fun onBindViewHolder(holder: CustomListAdapter.ViewHolder, position: Int) {
        val binding = holder.binding
        with(binding){


            productList?.let {
                list ->
                val item = list[position]
                val name = item.actor.display_login
                val type = item.type
                val image = item.actor.avatar_url
                binding.textviewName.text = name
                binding.textviewDetail.text = type

                Glide
                    .with(binding.imageviewProduct.context)
                    .load(item.actor.avatar_url)
                    .error(R.drawable.account)
                    .into(binding.imageviewProduct)
            }
        }
    }

    inner class ViewHolder(view: View,val binding:ActivityLitsBinding):
        RecyclerView.ViewHolder(view){

//        init {
//            binding.accPro.setOnClickListener{
//                val item = productList?.let {list->
//                    val item = list[adapterPosition]
//                    Intent(view.context, Proflie::class.java).apply {
//                        putExtra("API", item)
//                    }.run{
//                        view.context.startActivities(arrayOf(this))
//                    }
//                }
//            }
//        }

    }

}