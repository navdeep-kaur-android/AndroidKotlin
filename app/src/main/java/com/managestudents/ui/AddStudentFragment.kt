package com.managestudents.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.managestudents.R
import androidx.lifecycle.ViewModelProvider
import com.managestudents.data.Student
import com.managestudents.viewmodels.AddStudentViewModel
import kotlinx.android.synthetic.main.fragment_add_student.view.*


/**
 * Add Student class is to add student to the room database
 */
class AddStudentFragment : Fragment() {

    private lateinit var studentViewModel: AddStudentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)
        studentViewModel = ViewModelProvider(this).get(AddStudentViewModel::class.java)
        view.submitButton.setOnClickListener {
            val student = Student(0,
                view.et_first_name.text.toString(),
                view.et_course_name.text.toString(),
                Integer.parseInt(view.et_phone_number.text.toString()),
                view.et_email.text.toString())
            studentViewModel.addStudent(student)
            this.activity?.onBackPressed()
        }

        return view


    }
}