package com.geek.schoolapp.service

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.geek.schoolapp.dataModel.studentData
import org.json.JSONObject
import java.lang.reflect.Method

class addStudentService() {

    fun addStudent(data: studentData , context : Context) {
        val requestQueue = Volley.newRequestQueue(context)
        val obj = JSONObject()
        obj.put("username",data.userName)
        obj.put("password",data.passWord)
        obj.put("registeration_id",data.registrationNo)
        obj.put("standard",data.standard)
        obj.put("father_name",data.fatherName)
        obj.put("name",data.name)
        obj.put("roll_number",data.rollNO)
        val URL = "https://schoolapp1121.herokuapp.com/api/student"
        val request = JsonObjectRequest(Request.Method.POST,URL , obj ,
            {
                Toast.makeText(context, "Hey Registration of ${data.name} is successful ", Toast.LENGTH_SHORT).show()
        },
            {
                Toast.makeText(context, "Hey Registration of ${data.name} is Failed \n Please Retry after Sometime", Toast.LENGTH_SHORT).show()
            }
        )
        requestQueue.add(request)
    }
}