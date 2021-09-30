package com.geek.schoolapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.geek.schoolapp.databinding.AddStudentBinding
import com.geek.schoolapp.databinding.ViewDialogBinding

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
    }
}