package com.geek.schoolapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.geek.schoolapp.databinding.AddStudentBinding

class StudentProfile : AppCompatActivity() {
    lateinit var binding: AddStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.add_student)

        if (intent.extras != null) {
            binding.tvTitle.text = (intent.extras!!.get("tag")).toString()
        }
    }
}