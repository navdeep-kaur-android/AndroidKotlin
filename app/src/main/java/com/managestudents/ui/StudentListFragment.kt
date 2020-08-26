package com.managestudents.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.managestudents.R
import com.managestudents.adapters.MyStudentRecyclerViewAdapter
import com.managestudents.databinding.FragmentStudentListBinding
import com.managestudents.viewmodels.AddStudentViewModel

/**
 * A fragment representing a list of Items.
 */
class StudentListFragment : Fragment() {
    private lateinit var studentViewModel: AddStudentViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStudentListBinding.inflate(inflater, container, false)
        context ?: return binding.root
        val adapter = MyStudentRecyclerViewAdapter()
        binding.studentList.adapter = adapter
        studentViewModel = ViewModelProvider(this).get(AddStudentViewModel::class.java)
        subscribeUi(adapter)
       binding.fab.setOnClickListener (
           Navigation.createNavigateOnClickListener(R.id.action_show_add_student)
       )
        return binding.root
    }
    private fun subscribeUi(adapter: MyStudentRecyclerViewAdapter) {
        studentViewModel.students.observe(this.activity as AppCompatActivity, Observer { students ->
            // Update the cached copy of the words in the adapter.
            students?.let { adapter.setStudents(it) }
        })
        }
    }
