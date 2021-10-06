package com.geek.schoolapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class AppSharedPrefs : AppCompatActivity() {

    fun LoginPrefs(context: Context , userName: String, pass: String , isStaff : Boolean , userID : String){
        val sharedprefs = context.getSharedPreferences("loginPrefs", MODE_PRIVATE)
        val editor =  sharedprefs.edit()
        editor.apply {
            putString("username",userName)
            putString("pass",pass)
            putString("userID",userID)
            putBoolean("isStaff",isStaff)
            apply()
        }
    }
    fun deletePrefs(context: Context){
        val sharedprefs = context.getSharedPreferences("loginPrefs", MODE_PRIVATE)
        val editor = sharedprefs.edit()
        editor.clear()
        editor.apply()
    }
}