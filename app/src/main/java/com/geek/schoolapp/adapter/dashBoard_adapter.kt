package com.geek.schoolapp.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.geek.schoolapp.R
import com.geek.schoolapp.StudentProfile

class dashBoard_adapter(val data : List<String> , val imageData : List<Int>) : RecyclerView.Adapter<dashBoard_adapter.dashBoard_viewHolder>() {

    class dashBoard_viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val  txtView : TextView = itemView.findViewById(R.id.textView)
        val image : ImageView = itemView.findViewById(R.id.image)
        val cardView : CardView = itemView.findViewById(R.id.cardView)

        init {
            cardView.setOnClickListener{
                val intent = Intent(it.context,StudentProfile::class.java)
                intent.putExtra("tag" , txtView.text)
                Log.e("DashBoard_Adapter", ": ${txtView.text}" )
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dashBoard_viewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.single_dashborad_rcv,parent,false)
        return dashBoard_viewHolder(v)
    }

    override fun onBindViewHolder(holder: dashBoard_viewHolder, position: Int) {
        holder.txtView.text = data[position]
        holder.image.setImageResource(imageData[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}