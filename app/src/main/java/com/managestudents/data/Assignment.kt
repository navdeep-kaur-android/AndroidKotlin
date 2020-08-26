package com.managestudents.data

import androidx.room.*
import java.util.*

@Entity(tableName = "assignment", foreignKeys = [ForeignKey(entity = Student::class,parentColumns = ["id"], childColumns = ["student_id"])],
indices = [Index("student_id")])
data class Assignment(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val assignmentID: Int,
    @ColumnInfo(name = "student_id") val studentID: Int,
    @ColumnInfo(name = "title") val title: String,
    val description : String,
    @ColumnInfo(name = "due_date") val dueDate: Long,
    val price: Double,
    @ColumnInfo(name = "received_date") val receivedDate : Long
) {
    override fun toString(): String {
        return "Assignment: $title Description: $description  Received Date $receivedDate Due Date $dueDate"
    }
}