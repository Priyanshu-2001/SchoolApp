package com.geek.schoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.geek.schoolapp.adapter.dashBoard_adapter
import com.geek.schoolapp.databinding.ActivityAdminDashboardBinding

class admin_dashboard : AppCompatActivity() {

    lateinit var binding : ActivityAdminDashboardBinding
    val dashBoardList : ArrayList<String> = arrayListOf("Add Student", "Delete Student" , "Edit Student" , "View Student")
    val adapter = dashBoard_adapter(dashBoardList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_admin_dashboard)

        binding.rcv.adapter = adapter
    }
}