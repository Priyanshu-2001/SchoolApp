package com.geek.schoolapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class AppSharedPrefs : AppCompatActivity() {

    fun LoginPrefs(context: Context , userName: String, pass: String){
        val sharedprefs = context.getSharedPreferences("loginPrefs", MODE_PRIVATE)
        val editor =  sharedprefs.edit()
        editor.apply {
            putString("username",userName)
            putString("pass",pass)
            apply()
        }
    }
}