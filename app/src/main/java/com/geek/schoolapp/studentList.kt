package com.geek.schoolapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.geek.schoolapp.adapter.studentList_Adapter
import com.geek.schoolapp.databinding.StudentListRcvBinding
import com.geek.schoolapp.viewModel.studentViewModel
import com.geek.schoolapp.viewModel.studentViewModelFactory

class studentList : AppCompatActivity() {

    lateinit var binding : StudentListRcvBinding
    lateinit var viewModel: studentViewModel
    lateinit var list_adapter : studentList_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.student_list_rcv)
        binding.progressCircular.visibility = View.VISIBLE
        val selectedClass = intent.getIntExtra("class",0)
        val repo = (application as studentApplication).studentRepo
        viewModel = ViewModelProvider(this,studentViewModelFactory(repo,selectedClass)).get(studentViewModel::class.java)
        Log.e("TAG", "onCreate: $selectedClass", )

        //back button
        binding.backButton.setOnClickListener{
            finish()
        }

        viewModel.students.observe(this, Observer {
            Log.e("Student-List", "onCreate: $it")
            list_adapter = studentList_Adapter()
            binding.rcvStud.adapter = list_adapter
            list_adapter.submitList(it)
            binding.progressCircular.visibility = View.GONE
        })

    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshlist()
    }
}