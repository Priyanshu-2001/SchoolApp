package com.geek.schoolapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.geek.schoolapp.databinding.AddStudentBinding

class StudentProfile : AppCompatActivity() {
    lateinit var binding: AddStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.add_student)

        if (intent.extras != null) {
            Log.e("TAG", "onCreate: ")
            if (intent.extras!!.get("tag")?.equals("Add Student") == true) {
                binding.tvTitle.text = "Add Student"
            }
            if (intent.extras!!.get("tag")?.equals("Delete Student") == true) {
                binding.tvTitle.text = "Delete Student"
            }
            if (intent.extras!!.get("tag")?.equals("Edit Student") == true) {
                binding.tvTitle.text = "Edit Student"
            }
            if (intent.extras!!.get("tag")?.equals("View Student") == true) {
                binding.tvTitle.text = "View Student"
            }
        }
    }
}