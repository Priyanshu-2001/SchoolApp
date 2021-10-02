package com.geek.schoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.geek.schoolapp.databinding.ActivityMainBinding
import com.geek.schoolapp.service.loginService

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val service = loginService()
        val progressbar = binding.progressCircular
        binding.btnLogin.setOnClickListener {
            progressbar.visibility = View.VISIBLE
            service.login(binding.userName.text.toString() , binding.passField.text.toString() , this , progressbar)

        }
    }
}