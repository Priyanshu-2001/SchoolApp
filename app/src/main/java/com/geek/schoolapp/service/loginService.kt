package com.geek.schoolapp.service

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
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
                Toast.makeText(context, "Welcome...", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, admin_dashboard::class.java)
                context.startActivity(intent)
                context.finishAffinity()
            },
            {
                progressbar.visibility = View.GONE
                Toast.makeText(
                    context,
                    "Hey There, You are forgetting something !!\n Contact Your School Admin For More Help",
                    Toast.LENGTH_SHORT
                ).show()
            }

        )
        requestQueue.add(request)
    }
}