package com.geek.schoolapp.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.geek.schoolapp.R

class dashBoard_adapter(val data : List<String>) : RecyclerView.Adapter<dashBoard_adapter.dashBoard_viewHolder>() {


    class dashBoard_viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val  txtView : TextView = itemView.findViewById(R.id.textView)
        val image : ImageView = itemView.findViewById(R.id.image)
        val cardView : CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dashBoard_viewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.single_dashborad_rcv,parent,false)
        return dashBoard_viewHolder(v)
    }

    override fun onBindViewHolder(holder: dashBoard_viewHolder, position: Int) {
        holder.txtView.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }
}