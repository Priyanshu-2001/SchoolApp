package com.geek.schoolapp.service

import android.content.Context
import android.util.Base64
import android.util.Log
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.geek.schoolapp.dataModel.StudentData
import org.json.JSONObject
import java.util.*

class addStudentService() {

    fun addStudent(data: StudentData, context: Context) {
        val requestQueue = Volley.newRequestQueue(context)
        val obj = JSONObject()
        val standard: Int = data.standard as Int
        val roll: Int = data.rollNO as Int
        obj.put("username", data.userName)
        obj.put("password", data.passWord)
        obj.put("registeration_id", data.registrationNo)
        obj.put("standard", standard)
        obj.put("father_name", data.fatherName)
        obj.put("name", data.name)
        obj.put("roll_number", roll)
        val URL = "https://schoolapp1121.herokuapp.com/api/student"

        val request = object : JsonObjectRequest(1, URL, obj,
            {
                Toast.makeText(
                    context,
                    "Hey Registration of ${data.name} is successful ",
                    Toast.LENGTH_SHORT
                ).show()
            },
            {
                Toast.makeText(
                    context,
                    "Hey Registration of ${data.name} is Failed \n Please Retry after Sometime",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("TAG", "addStudent: $it")
            }
        ) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String?> {
                val params: MutableMap<String, String> = HashMap()
                val creds = String.format(
                    "%s:%s",
                    "admin123",
                    "123"
                )
                val auth = "Basic " + Base64.encodeToString(creds.toByteArray(), Base64.DEFAULT)
                params["Authorization"] = auth
                return params

            }
        }
        requestQueue.add(request)
    }
}