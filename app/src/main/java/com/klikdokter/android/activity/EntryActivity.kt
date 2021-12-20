package com.klikdokter.android.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.klikdokter.android.databinding.ActivityEntryBinding
import com.klikdokter.android.viewmodel.AuthViewModel

class EntryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEntryBinding
    private var authViewModel: AuthViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        authViewModel?.init()

        val type = intent.getStringExtra("type").orEmpty()
        binding.tvAction.text = type
        binding.tvAction.setOnClickListener {
            actionLogin(type)
        }
    }

    private fun actionLogin(type: String) {
        authViewModel?.actionLogin(
            binding.etEmail.text.toString(),
            binding.etPassword.text.toString()
        )?.observe(this, {
            if (it.first) {
                finish()
            } else {
                Toast.makeText(this, it.second, Toast.LENGTH_SHORT).show()
            }
        })
    }
}