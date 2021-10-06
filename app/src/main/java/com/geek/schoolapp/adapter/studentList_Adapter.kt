package com.geek.schoolapp.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geek.schoolapp.R
import com.geek.schoolapp.StudentProfile
import com.geek.schoolapp.dataModel.studentItem
import com.geek.schoolapp.databinding.SingleStudRcvBinding

class studentList_Adapter :
    ListAdapter<studentItem, studentList_Adapter.studentList_VH>(DiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): studentList_VH {
        val binding = DataBindingUtil.inflate<SingleStudRcvBinding>(
            LayoutInflater.from(parent.context),
            R.layout.single_stud_rcv, parent, false
        )
        return studentList_VH(binding)
    }

    override fun onBindViewHolder(holder: studentList_VH, position: Int) {
        holder.Bind(getItem(position))
    }

    class studentList_VH(itemView: SingleStudRcvBinding) : RecyclerView.ViewHolder(itemView.root) , View.OnClickListener {
        var binding: SingleStudRcvBinding = itemView
        lateinit var tempItem : studentItem

        init {
            binding.cardView.setOnClickListener(this)
        }
        fun Bind(item: studentItem) {
            tempItem = item
            binding.studName.text = item.name
            binding.studRollno.text = item.roll_number.toString()
            binding.studRegno.text = item.registeration_id
        }

        override fun onClick(view: View) {
            val i = Intent(view.context,StudentProfile::class.java)
            i.putExtra("tag","View Student")
            val bund = Bundle()
            bund.putString("regId" ,tempItem.registeration_id)
            bund.putString("fatherName" ,tempItem.father_name)
            bund.putString("name" ,tempItem.name)
            bund.putInt("rollNo" ,tempItem.roll_number)
            bund.putInt("standard" ,tempItem.standard)
            i.putExtra("bund",bund)
            view.context.startActivity(i)
        }
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<studentItem>() {
        override fun areItemsTheSame(oldItem: studentItem, newItem: studentItem): Boolean {
            return oldItem.registeration_id == newItem.registeration_id
        }

        override fun areContentsTheSame(oldItem: studentItem, newItem: studentItem): Boolean {
            return oldItem == newItem
        }
    }
}