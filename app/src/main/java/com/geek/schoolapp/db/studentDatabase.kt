package com.geek.schoolapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.geek.schoolapp.dataModel.studentItem

@Database(entities = [studentItem::class] , version = 2)
abstract class studentDatabase : RoomDatabase() {
    abstract fun studentDao() : studentDAO

    companion object{
        @Volatile
        private var INSTANCE : studentDatabase? = null

        fun getDatabase(context : Context) : studentDatabase{
            if(INSTANCE==null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                    studentDatabase::class.java,
                    "studentDB")
                        .build()
                }
            }
                return INSTANCE!!
        }
    }
}