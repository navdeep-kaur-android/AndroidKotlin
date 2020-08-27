package com.managestudents.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.managestudents.R
import com.managestudents.data.Student

/**
 * Adapter class set for showing the list of students
 * Navdeep Kaur
 */
class MyStudentRecyclerViewAdapter() : RecyclerView.Adapter<MyStudentRecyclerViewAdapter.StudentViewHolder>() {

    private var students = emptyList<Student>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val item = students[position]
        holder.idView.text = item.name
        holder.contentView.text = item.course
    }

    internal fun setStudents(students: List<Student>) {
        this.students = students
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = students.size

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_name)
        val contentView: TextView = view.findViewById(R.id.item_course)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}