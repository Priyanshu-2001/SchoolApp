package com.geek.schoolapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.geek.schoolapp.dataModel.StudentData
import com.geek.schoolapp.databinding.AddStudentBinding
import com.geek.schoolapp.service.Delete_Edit_Service
import com.geek.schoolapp.service.addStudentService

class StudentProfile : AppCompatActivity() {
    lateinit var binding: AddStudentBinding
    lateinit var whichText: String
    lateinit var edit_delte_Service: Delete_Edit_Service
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
            edit_delte_Service = Delete_Edit_Service()
        }

        //back button
        binding.backButton.setOnClickListener{
            finish()
        }
    }


    private fun viewStudentConfig() {
        binding.tvTitle.text = "Student"
        binding.btnSave.text = "Edit Details"
        binding.deleteBtn.visibility = View.VISIBLE

        val bundle = intent.getBundleExtra("bund")
        val regID = bundle?.get("regId")
        val father = bundle?.get("fatherName")
        val name = bundle?.get("name")
        val rollNo = bundle?.get("rollNo")
        val standard = bundle?.get("standard")

        binding.classSpinner.setSelection(standard as Int)
        disableAll()

        binding.deleteBtn.setOnClickListener {
            edit_delte_Service.delete_Student()
        }

        val studentData = StudentData(
            name as String,
            rollNo.toString(),
            standard,
            regID as String,
            father as String
        )
        binding.viewmodel = studentData

        binding.btnSave.setOnClickListener {

            if(binding.btnSave.text == getString(R.string.saveChangesBtn)) {
                binding.btnSave.text = getString(R.string.editBtn)
                binding.deleteBtn.visibility = View.VISIBLE
                disableAll()
                saveChanges()
            }else{
            binding.btnSave.text = getString(R.string.saveChangesBtn)
            enableAll()
            binding.deleteBtn.visibility = View.GONE
        }
        }
    }

    private fun saveChanges() {
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show()
        binding.btnSave.text = "Edit Details"
        edit_delte_Service.edit_Student()
    }

    private fun disableAll() {
        binding.nameField.isEnabled = false
        binding.rollfield.isEnabled = false
        binding.regField.isEnabled = false
        binding.fnameField.isEnabled = false
    }

    private fun enableAll() {
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
                    binding.rollfield.text.toString(),
                    classSelected,
                    binding.regField.text.toString(),
                    binding.fnameField.text.toString()
                )
                data.passWord = binding.password.text.toString()
                data.userName = binding.username.text.toString()

                service.addStudent(data, this)
            } else {
                Toast.makeText(
                    it.context,
                    "Hey You Forgot to Select the class ",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}