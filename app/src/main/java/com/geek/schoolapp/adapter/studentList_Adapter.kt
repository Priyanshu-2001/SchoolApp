package com.geek.schoolapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geek.schoolapp.R
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

    class studentList_VH(itemView: SingleStudRcvBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding: SingleStudRcvBinding = itemView

        fun Bind(item: studentItem) {
            binding.studName.text = item.name
            binding.studRollno.text = item.roll_number.toString()
            binding.studRegno.text = item.registeration_id
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