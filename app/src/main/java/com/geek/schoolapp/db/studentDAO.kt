package com.geek.schoolapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geek.schoolapp.dataModel.studentItem

@Dao
interface studentDAO {
    @Insert
    suspend fun addStudent(student : ArrayList<studentItem>)

    @Query("SELECT * FROM student WHERE standard LIKE :filter")
    fun getStudent(filter : Int) : List<studentItem>

}