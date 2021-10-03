package com.geek.schoolapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geek.schoolapp.R
import com.geek.schoolapp.dataModel.studentData
import com.geek.schoolapp.databinding.SingleStudRcvBinding

class studentList_Adapter :
    ListAdapter<studentData, studentList_Adapter.studentList_VH>(DiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): studentList_VH {
        val binding = DataBindingUtil.inflate<SingleStudRcvBinding>(
            LayoutInflater.from(parent.context),
            R.layout.single_stud_rcv, parent, false
        )
        return studentList_VH(binding)
    }

    override fun onBindViewHolder(holder: studentList_VH, position: Int) {

    }

    class studentList_VH(itemView: SingleStudRcvBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun Bind() {

        }
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<studentData>() {
        override fun areItemsTheSame(oldItem: studentData, newItem: studentData): Boolean {
            return oldItem.registrationNo == newItem.registrationNo
        }

        override fun areContentsTheSame(oldItem: studentData, newItem: studentData): Boolean {
            return oldItem == newItem
        }
    }
}