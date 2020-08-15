package com.example.testwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.codemobiles.mystock.com.example.testwork.showToast
import com.example.testwork.adapter.CustomListAdapter
import com.example.testwork.databinding.ActivityProflieBinding
import com.example.testwork.models.UserName
import com.example.testwork.servicoes.APIClient
import com.example.testwork.servicoes.APIServicoes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Proflie : AppCompatActivity() {
    private lateinit var binding: ActivityProflieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proflie)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val display = intent.getStringExtra("display_login")
        val id = intent.getStringExtra("idacc")
        val avatar = intent.getStringExtra("avatar_url")
        val name_login = intent.getStringExtra("login")
        val gravatar = intent.getStringExtra("gravatar_id")
        val urls = intent.getStringExtra("url")
        val username =
            APIClient.getClient().create(APIServicoes::class.java).getUserName(name_login)
                .let { call ->
                    call.enqueue(object : Callback<UserName> {
                        override fun onFailure(call: Call<UserName>, t: Throwable) {
                            showToast(t.message.toString())
                            Log.d("cm_network", call.request().url().toString())
                        }
                        override fun onResponse(
                            call: Call<UserName>,
                            response: Response<UserName>
                        ) {
                            if (response.isSuccessful) {
                                binding.UserName.text = response.body()?.name
                                binding.following.text = ("${response.body()?.following} following")
                                binding.followers.text = ("${response.body()?.followers} followers")

                            } else {
                                showToast(response.message())
                            }

                        }

                    })
                }

        supportActionBar?.title = display
        binding = ActivityProflieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.LoginName.text = name_login
        binding.idAcc.text = ("ID : ${id}")
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