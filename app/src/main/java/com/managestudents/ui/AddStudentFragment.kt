package com.managestudents.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.managestudents.R
import com.managestudents.presenter.AddStudentPresenter
import com.managestudents.presenter.AddStudentPresenterImpl
import com.managestudents.utility.Utilities
import com.managestudents.view.AddStudentView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_add_student.view.*


/**
 * Add Student class is to add student to the room database
 */
class AddStudentFragment : Fragment(),AddStudentView {
    private val addStudentPresenter: AddStudentPresenter? = AddStudentPresenterImpl()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)
        view.submitButton.setOnClickListener {
            if (addStudentPresenter != null)
                addStudentPresenter.validateData(view.et_first_name.text.toString(),view.et_course_name.text.toString(),view.et_email.text.toString(),view.et_phone_number.text.toString())
            else
                Utilities.showToast(this.activity as AppCompatActivity,getString(R.string.unexpected_error))
        }
        return view


    }

    override fun onDataValidated() {
        TODO("Not yet implemented")
    }

    override fun onError(message: String) {
        TODO("Not yet implemented")
    }
}