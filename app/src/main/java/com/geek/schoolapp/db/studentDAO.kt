package com.geek.schoolapp.db

import androidx.room.*
import com.geek.schoolapp.dataModel.studentItem

@Dao
interface studentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudent(student : ArrayList<studentItem>)


    @Query("SELECT * FROM student WHERE standard LIKE :filter")
    fun getStudent(filter : Int) : List<studentItem>

}