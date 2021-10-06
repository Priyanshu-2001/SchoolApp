package com.geek.schoolapp.service

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.geek.schoolapp.dataModel.StudentData

class getStudentDetails {
    fun getdetails(context: Context) : MutableLiveData<StudentData> {
        lateinit var data : StudentData
        var liveData = MutableLiveData<StudentData>()

        val prefs = context.getSharedPreferences("loginPrefs", AppCompatActivity.MODE_PRIVATE)
        val requestQueue = Volley.newRequestQueue(context)
        val URL = "https://schoolapp1121.herokuapp.com/api/user/" + prefs.getString("userID", "k")
        val request = JsonObjectRequest(
            Request.Method.GET, URL, null,
            {
                val name = it.getString("name")
                val standard = it.getString("standard")
                val roll = it.getString("roll_number")
                val father = it.getString("father_name")
                val registerationID = it.getString("registeration_id")
                Log.e("TAG", "getdetails: $it")
                data = StudentData(name,roll,standard,registerationID,father)
                liveData.postValue(data)
            },
            {
                Toast.makeText(
                    context,
                    "There is some Error in your Data",
                    Toast.LENGTH_SHORT
                ).show()
                Toast.makeText(context, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        )
        requestQueue.add(request)
        return liveData
    }
}