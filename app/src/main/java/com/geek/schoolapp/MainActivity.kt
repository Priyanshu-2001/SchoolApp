package com.geek.schoolapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
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
        val sharedPrefs = getSharedPreferences("loginPrefs", MODE_PRIVATE)

        if(sharedPrefs.contains("username") && sharedPrefs.contains("pass")){
            lateinit var intent : Intent
            if(sharedPrefs.getBoolean("isStaff",false)) {
                intent = Intent(this, admin_dashboard::class.java)
            }else{
                intent = Intent(this,StudentProfile::class.java)
            }
            startActivity(intent)
            finishAffinity()
        }

        binding.btnLogin.setOnClickListener {
            progressbar.visibility = View.VISIBLE
            hideKeyboard(it)
            if ((binding.userName.text.toString() != "") && (binding.passField.text.toString() != "") )
                service.login(binding.userName.text.toString() , binding.passField.text.toString() , this , progressbar)
            else{
                progressbar.visibility = View.GONE
                Toast.makeText(this, "Fields are Empty !", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}