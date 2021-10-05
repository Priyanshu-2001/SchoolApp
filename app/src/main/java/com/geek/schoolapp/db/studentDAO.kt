package com.geek.schoolapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geek.schoolapp.dataModel.studentItem
import com.geek.schoolapp.dataModel.studentX

@Dao
interface studentDAO {
    @Insert
    suspend fun addStudent(student : studentX)

    @Query("SELECT * FROM student WHERE standard LIKE :filter")
    suspend fun getStudent(filter : Int?) : List<studentItem>

}