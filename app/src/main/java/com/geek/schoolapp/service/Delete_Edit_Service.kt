package com.geek.schoolapp.service

import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.geek.schoolapp.StudentProfile
import com.geek.schoolapp.dataModel.StudentData
import org.json.JSONObject

class Delete_Edit_Service : AppCompatActivity(){
    fun delete_Student( context: StudentProfile, regID: Any?) {
        val requestQueue = Volley.newRequestQueue(context)
        val obj = JSONObject()
        val URL = "https://schoolapp1121.herokuapp.com/api/user/"+regID.toString()
        val request =  JsonObjectRequest(
            Request.Method.DELETE, URL, obj,
            {
                context.finish()
                Toast.makeText(
                    context,
                    "Deletion done !",
                    Toast.LENGTH_SHORT
                ).show()
            },
            {
                context.finish()
                Toast.makeText(
                    context,
                    "Deletion DONE !",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("TAG", "addStudent: ${it.localizedMessage}")
            }
        )
        requestQueue.add(request)
    }

    fun edit_Student(data: StudentData, context: StudentProfile, regID: Any?) {

        val requestQueue = Volley.newRequestQueue(context)
        val obj = JSONObject()
        val roll: Int = Integer.valueOf(data.rollNO)
        obj.put("registeration_id", data.registrationNo)
        Log.e("TAG", "edit_Student:regno. ${data.registrationNo}")
        obj.put("father_name", data.fatherName)
        obj.put("name", data.name)
        obj.put("roll_number", roll)
        Log.d("TAG", "edit_Student_data: " + obj)
        val URL = "https://schoolapp1121.herokuapp.com/api/user/"+regID.toString()
//        Toast.makeText(context, URL, Toast.LENGTH_SHORT).show()
        val request =  JsonObjectRequest(
            Request.Method.PUT, URL, obj,
            {
                Toast.makeText(
                    context,
                    "Changes done !",
                    Toast.LENGTH_SHORT
                ).show()
            },
            {
                Toast.makeText(
                    context,
                    "Changes Failed !",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("TAG", "addStudent: $it")
            }
        )
        requestQueue.add(request)
    }

}