package com.managestudents.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AssignmentDao {

    @Transaction
    @Query("SELECT * FROM student WHERE id IN (SELECT DISTINCT(student_id) FROM assignment)")
    fun getStudentAssignments(): LiveData<List<StudentAndAssignmentJoin>>

    @Insert
    fun addAssignment(assignment: Assignment)

    @Query("SELECT * FROM assignment ORDER BY due_date")
    fun getAssignments(): LiveData<List<Assignment>>

    @Query("SELECT * FROM student WHERE id IN (SELECT student_id FROM assignment WHERE id = :assignmentID)")
    fun getAssignments(assignmentID : Int): LiveData<Student>

    @Query("Delete FROM assignment WHERE id = :assignmentID")
    fun deleteAssignment(assignmentID: Int)

}