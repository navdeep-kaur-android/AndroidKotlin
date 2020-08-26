package com.managestudents.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    val name : String,
    val course : String,
    @ColumnInfo(name = "phone_number")val phoneNumber : Int,
    val email : String){
    override fun toString(): String {
        return ("Name: $name Course: $course Phone Number $phoneNumber Email $email")
    }
}

