package com.managestudents.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.managestudents.R
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.managestudents.data.Student
import com.managestudents.viewmodels.StudentListViewModel
import kotlinx.android.synthetic.main.fragment_add_student.view.*


/**
 * Add Student class is to add student to the room database
 */
class AddStudentFragment : Fragment() {

    private lateinit var studentListViewModel: StudentListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)
        studentListViewModel = ViewModelProvider(this).get(StudentListViewModel::class.java)
        view.submitButton.setOnClickListener {
            val student = Student(0,
                view.et_first_name.text.toString(),
                view.et_course_name.text.toString(),
                Integer.parseInt(view.et_phone_number.text.toString()),
                view.et_email.text.toString())
            studentListViewModel.addStudent(student)
            this.activity?.onBackPressed()
        }
        view.addAssignmentButton.setOnClickListener{
            val navController: NavController = Navigation.findNavController(it)
            navController.navigate(R.id.action_add_student_fragment_to_addAssignmentFragment)
        }
        return view


    }
}