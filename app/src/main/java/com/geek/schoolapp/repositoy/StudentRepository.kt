package com.geek.schoolapp.repositoy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geek.schoolapp.dataModel.student
import com.geek.schoolapp.service.studentListApi

class StudentRepository(private val studentList: studentListApi) {
    private val studentLiveData = MutableLiveData<student>()

    val list : LiveData<student>
        get() = studentLiveData

    suspend fun getStudents(standard : Any){
        val result = studentList.getStudentList(standard)
        if(result!=null){
            if(result.body()!=null){
                studentLiveData.postValue(result.body())
            }

        }
    }
}