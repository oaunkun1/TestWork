package com.example.testwork

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.codemobiles.mystock.com.example.testwork.showToast
import com.example.testwork.R

import com.example.testwork.databinding.ActivityProflieBinding

import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class Proflie : AppCompatActivity() {



    private lateinit var binding: ActivityProflieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proflie)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val display = intent.getStringExtra("display_login")
        val id = intent.getStringExtra("idacc")
        val avatar = intent.getStringExtra("avatar_url")
        val login = intent.getStringExtra("login")
        val gravatar = intent.getStringExtra("gravatar_id")
        val urls = intent.getStringExtra("url")

        supportActionBar?.title = display

        binding = ActivityProflieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nameDisplay.text = login
        binding.idAcc.text = ("ID : ${id}")
        binding.gravatarAcc.text = ("gravatar : ${gravatar}")
        binding.urlAcc.text = urls
        Glide
            .with(binding.proAcc.context)
            .load(avatar)
            .error(R.drawable.account)
            .into(binding.proAcc)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}