package com.example.testwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.codemobiles.mystock.com.example.testwork.showToast
import com.example.testwork.databinding.ActivityProflieBinding
import com.example.testwork.models.JsonResult

class Proflie : AppCompatActivity() {
    private var profileacc: JsonResult? = null
    private lateinit var binding: ActivityProflieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proflie)

        binding = ActivityProflieBinding.inflate(layoutInflater)
//        profileacc = intent.getParcelableExtra("API")
        setupWidget()
    }

    private fun setupWidget() {
        profileacc?.let {profileacc ->

            Glide
                .with(binding.profileAc.context)
                .load(profileacc.actor.avatar_url)
                .error(R.drawable.account)
                .into(binding.profileAc)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}