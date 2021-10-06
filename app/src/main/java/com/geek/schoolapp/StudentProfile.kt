package com.geek.schoolapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.geek.schoolapp.dataModel.StudentData
import com.geek.schoolapp.databinding.AddStudentBinding
import com.geek.schoolapp.service.addStudentService

class StudentProfile : AppCompatActivity() {
    lateinit var binding: AddStudentBinding
    lateinit var whichText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.add_student)

        if (intent.extras != null) {
            binding.tvTitle.text = (intent.extras!!.get("tag")).toString()
            whichText = (intent.extras!!.get("tag")).toString()
        }
        if (whichText == "Add Student") {
            addStudentConfig()
        }
        if (whichText == "View Student") {
            viewStudentConfig()
        }
    }

    private fun viewStudentConfig() {
        binding.tvTitle.text = "Student"
        binding.btnSave.text = "Edit Details"
        val bundle = intent.getBundleExtra("bund")
        val regID = bundle?.get("regId")
        val father = bundle?.get("fatherName")
        val name = bundle?.get("name")
        val rollNo = bundle?.get("rollNo")
        val standard = bundle?.get("standard")
        binding.classSpinner.setSelection(standard as Int)
        disableAll()
        val studentData = standard?.let {
            StudentData(name as String, rollNo as Int,
                it, regID as String, father as String
            )
        }
        binding.viewmodel = studentData

        if(binding.btnSave.text=="Edit Details") {
            binding.btnSave.setOnClickListener {
                binding.btnSave.text = "Save Changes"
                enableAll()
            }
        }else{
            saveChanges()
        }
    }

    private fun saveChanges() {
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show()
        binding.btnSave.text = "Edit Details"
    }

    private fun disableAll(){
        binding.nameField.isEnabled = false
        binding.rollfield.isEnabled = false
        binding.regField.isEnabled = false
        binding.fnameField.isEnabled = false
    }
    private fun enableAll(){
        binding.nameField.isEnabled = true
        binding.rollfield.isEnabled = true
        binding.regField.isEnabled = true
        binding.fnameField.isEnabled = true
    }

    private fun addStudentConfig() {
        binding.userNameBox.visibility = View.VISIBLE
        binding.passwordBox.visibility = View.VISIBLE
        val service = addStudentService()

        binding.btnSave.setOnClickListener {
            val classSelected = binding.classSpinner.selectedItemPosition
            if (classSelected != 0) {
                val data = StudentData(
                    binding.nameField.text.toString(),
                    Integer.valueOf(binding.rollfield.text.toString()),
                    classSelected,
                    binding.regField.text.toString(),
                    binding.fnameField.text.toString()
                )
                data.passWord = binding.password.text.toString()
                data.userName = binding.username.text.toString()

                service.addStudent(data, this)
            }else{
                Toast.makeText(it.context, "Hey You Forgot to Select the class ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}