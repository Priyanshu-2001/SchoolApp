package com.geek.schoolapp.dataModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class studentItem(
    val father_name: String,
    val is_staff: Boolean,
    val name: String,
    @PrimaryKey
    val registeration_id: String,
    val roll_number: Int,
    val standard: Int,
    val username: String
)