package com.managestudents.data

import androidx.room.Embedded
import androidx.room.Relation

data class StudentAndAssignmentJoin(@Embedded val student: Student,
@Relation(parentColumn = "id", entityColumn = "student_id")
val assignmentList: List<Assignment> = emptyList())
