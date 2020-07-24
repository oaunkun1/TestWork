package com.example.testwork

import android.app.Activity
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testwork.adapter.CustomListAdapter
import com.example.testwork.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var customAdapter: CustomListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        customAdapter = CustomListAdapter(arrayListOf("aaa","bbb","ccc"))

        setContentView(binding.root)
        binding.listRecyclerView.apply {
            adapter = customAdapter

            layoutManager = GridLayoutManager(context,2)

        }.also {
            it. addItemDecoration(GridSpacingItemDecoration(2,20,true))
            it.setHasFixedSize(true)
        }
    }
}