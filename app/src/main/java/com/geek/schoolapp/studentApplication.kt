package com.geek.schoolapp

import android.app.Application
import com.geek.schoolapp.db.studentDatabase
import com.geek.schoolapp.repositoy.StudentRepository
import com.geek.schoolapp.retrofitHelper.retroHelper_StudentList
import com.geek.schoolapp.service.studentListApi

class studentApplication : Application() {

    lateinit var studentRepo: StudentRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val service = retroHelper_StudentList().getInstance().create(studentListApi::class.java)
        val db = studentDatabase.getDatabase(applicationContext)
        studentRepo = StudentRepository(service,db,applicationContext)
    }
}