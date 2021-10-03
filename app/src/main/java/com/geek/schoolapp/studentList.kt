package com.geek.schoolapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.geek.schoolapp.databinding.StudentListRcvBinding
import com.geek.schoolapp.retrofitHelper.retroHelper_StudentList
import com.geek.schoolapp.service.studentListApi
import com.geek.schoolapp.service.studentService
import com.geek.schoolapp.viewModel.studentViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class studentList : AppCompatActivity() {

    lateinit var binding : StudentListRcvBinding
    lateinit var viewModel: studentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.student_list_rcv)
        val selectedClass = intent.getStringExtra("class")



        val service = studentService()
        service.getStudentList(selectedClass)

        val api = retroHelper_StudentList().getInstance().create(studentListApi::class.java)
        GlobalScope.launch {
            val res = selectedClass?.let { api.getStudentList(it) }

            if(res!=null){
                Log.e("TAG", "onCreate: ${res.body()}", )
            }
        }
    }
}