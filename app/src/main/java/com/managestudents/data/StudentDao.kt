package com.managestudents.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * FROM student ORDER BY name")
    fun getAllStudents() : LiveData<List<Student>>

    @Query("SELECT * FROM student WHERE id = :studentID")
    fun getStudent(studentID : Int) : LiveData<Student>

    @Query("SELECT * FROM student WHERE name LIKE '%' || :search || '%'")
    fun searchStudents(search : String) : LiveData<List<Student>>

    @Insert
    fun addStudent(student: Student)

    @Query("Delete FROM student WHERE id = :studentID")
    fun deleteStudent(studentID : Int)
}
