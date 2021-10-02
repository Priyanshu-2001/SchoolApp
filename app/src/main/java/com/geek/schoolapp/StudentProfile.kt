package com.geek.schoolapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.geek.schoolapp.dataModel.studentData
import com.geek.schoolapp.databinding.AddStudentBinding
import com.geek.schoolapp.service.addStudentService

class StudentProfile : AppCompatActivity() {
    lateinit var binding: AddStudentBinding
    lateinit var whichText :String

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.add_student)

        if (intent.extras != null) {
            binding.tvTitle.text = (intent.extras!!.get("tag")).toString()
           whichText = (intent.extras!!.get("tag")).toString()
        }
            if(whichText == "Add Student"){
                addStudentConfig()
            }
    }

    private fun addStudentConfig() {
        binding.userNameBox.visibility = View.VISIBLE
        binding.passwordBox.visibility = View.VISIBLE
        val data = studentData(binding.nameField.text.toString() , binding.rollfield.text.toString() ,"class" ,binding.regField.text.toString() ,binding.fnameField.text.toString())
        data.passWord = binding.password.text.toString()
        data.userName = binding.username.text.toString()
        val service = addStudentService()
        binding.btnSave.setOnClickListener {
            service.addStudent(data,this)
        }
    }
}