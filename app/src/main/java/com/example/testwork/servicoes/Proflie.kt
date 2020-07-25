package com.example.testwork.servicoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.codemobiles.mystock.com.example.testwork.showToast
import com.example.testwork.R

import com.example.testwork.databinding.ActivityProflieBinding

class Proflie : AppCompatActivity() {

    private lateinit var binding: ActivityProflieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proflie)

        val display =  intent.getStringExtra("display_login")
        val id = intent.getStringExtra("idaCC")
        val avatar = intent.getStringExtra("avatar_url")
        val login = intent.getStringExtra("login")
        val gravatar = intent.getStringExtra("gravatar_id")
        val url = intent.getStringExtra("url")

        supportActionBar?.title = display

        binding = ActivityProflieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nameDisplay.text = login
        binding.idAcc.text = id
        binding.gravatarAcc.text = gravatar
        binding.urlAcc.text = url
        Glide
            .with(binding.proAcc.context)
            .load(avatar)
            .error(R.drawable.account)
            .into(binding.proAcc)
     }
}