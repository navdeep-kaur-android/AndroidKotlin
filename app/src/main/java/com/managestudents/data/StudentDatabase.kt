package com.managestudents.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


const val DATABASE_NAME = "student_database"
@Database(entities = [Assignment::class, Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun assignmentDao(): AssignmentDao

    companion object {

       //This method is to instantiate the class
        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getInstance(context: Context) : StudentDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, StudentDatabase::class.java,
                    DATABASE_NAME).build()
                INSTANCE = instance
                return instance
            }
        }
        }
    }