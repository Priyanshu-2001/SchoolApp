package com.geek.schoolapp.service

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.geek.schoolapp.AppSharedPrefs
import com.geek.schoolapp.StudentProfile
import com.geek.schoolapp.admin_dashboard
import org.json.JSONObject

class loginService {
    fun login(userName: String, pass: String, context: Activity, progressbar: ProgressBar) {
        progressbar.visibility = View.VISIBLE
        val requestQueue = Volley.newRequestQueue(context)
        val obj = JSONObject()
        obj.put("username", userName)
        obj.put("password", pass)
        val URL = "https://schoolapp1121.herokuapp.com/api/login"
        val request = JsonObjectRequest(
            Request.Method.POST, URL, obj,
            {
                progressbar.visibility = View.GONE
                val isStaff : Boolean = it.get("is_staff") as Boolean
                AppSharedPrefs().LoginPrefs(context,userName,pass,isStaff = isStaff, it.getString("registeration_id"))
                Toast.makeText(context, "Welcome...", Toast.LENGTH_LONG).show()


                val intent : Intent = if(isStaff) {
                    Intent(context, admin_dashboard::class.java)
                }else{
                    Intent(context,StudentProfile::class.java)
                }
                if(!isStaff){
//                    val bund = Bundle()
//                    bund.putString("regId", it.get("registeration_id").toString())
//                    bund.putString("fatherName", it.get("father_name").toString())
//                    bund.putString("name", it.get("name").toString())
//                    bund.putInt("rollNo", Integer.valueOf(it.get("roll_number").toString()))
//                    bund.putInt("standard", Integer.valueOf(it.get("standard").toString()))
//                    intent.putExtra("bundle", bund)
                    intent.putExtra("tag", "Student")
                }
                context.startActivity(intent)
                context.finishAffinity()
            },
            {
                progressbar.visibility = View.GONE
                Toast.makeText(
                    context,
                    "Hey There, You are forgetting something !!\n Contact Your School/Admin For More Help",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
        requestQueue.add(request)
    }
}