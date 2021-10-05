package com.geek.schoolapp.repositoy

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geek.schoolapp.dataModel.studentX
import com.geek.schoolapp.db.studentDatabase
import com.geek.schoolapp.service.studentListApi
import com.geek.schoolapp.utils.NetworkUtils

class StudentRepository(
    private val studentList: studentListApi,
    private val studentDatabase: studentDatabase,
    private val applicationContext: Context
) {
    private val studentLiveData = MutableLiveData<studentX>()

    val list : LiveData<studentX>
        get() = studentLiveData

    suspend fun getStudents(standard : Int){

        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = studentList.getStudentList(standard)
            if(result.body()!=null){
                studentDatabase.studentDao().addStudent(result.body()!!)
                Log.e("Server data ", "getStudents: ${result.body()}" )
                studentLiveData.postValue(result.body())
            }
        }else{
            val student = studentDatabase.studentDao().getStudent(standard)
            lateinit var x : studentX
            student.forEach{
                x.add(it)
                Log.e("db data ", "getStudents: $it" )
            }
            studentLiveData.postValue(x)
        }

    }
}