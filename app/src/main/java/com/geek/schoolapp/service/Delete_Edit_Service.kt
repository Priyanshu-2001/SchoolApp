package com.geek.schoolapp.service

import android.content.Intent
import android.os.Bundle
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
    fun delete_Student(){

    }

    fun edit_Student(data: StudentData, context: StudentProfile, regID: Any?) {

        val i = Intent(context,StudentProfile::class.java)
        val bund = Bundle()
        val requestQueue = Volley.newRequestQueue(context)
        val obj = JSONObject()
        val roll: Int = Integer.valueOf(data.rollNO)
        obj.put("registeration_id", data.registrationNo)
        obj.put("father_name", data.fatherName)
        obj.put("name", data.name)
        obj.put("roll_number", roll)
        Log.d("TAG", "edit_Student_data: " + obj)
        val URL = "https://schoolapp1121.herokuapp.com/api/user/"+regID.toString()
        Toast.makeText(context, URL, Toast.LENGTH_SHORT).show()
        val request =  JsonObjectRequest(
            Request.Method.PUT, URL, obj,
            {
                Toast.makeText(
                    context,
                    "Changes done !",
                    Toast.LENGTH_SHORT
                ).show()
                bund.putString("regId" ,data.registrationNo)
                i.putExtra("bund",bund)
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