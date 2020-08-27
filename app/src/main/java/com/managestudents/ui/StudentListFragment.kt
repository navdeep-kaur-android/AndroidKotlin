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
import com.managestudents.viewmodels.StudentListViewModel

/**
 * A fragment representing a list of Items.
 */
class StudentListFragment : Fragment() {
    private lateinit var studentListViewModel: StudentListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStudentListBinding.inflate(inflater, container, false)
        context ?: return binding.root
        val adapter = MyStudentRecyclerViewAdapter()
        binding.studentList.adapter = adapter
        studentListViewModel = ViewModelProvider(this).get(StudentListViewModel::class.java)
        subscribeUi(adapter)
       binding.fab.setOnClickListener (
           Navigation.createNavigateOnClickListener(R.id.action_show_add_student)
       )
        return binding.root
    }
    private fun subscribeUi(adapter: MyStudentRecyclerViewAdapter) {
        studentListViewModel.students.observe(this.activity as AppCompatActivity, Observer { students ->
            // Update the cached copy of the words in the adapter.
            students?.let { adapter.setStudents(it) }
        })
        }
    }
