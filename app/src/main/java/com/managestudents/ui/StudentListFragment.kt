package com.managestudents.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.managestudents.R
import com.managestudents.databinding.FragmentStudentListBinding

/**
 * A fragment representing a list of Items.
 */
class StudentListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStudentListBinding.inflate(inflater, container, false)
        context ?: return binding.root
       binding.fab.setOnClickListener (
           Navigation.createNavigateOnClickListener(R.id.action_show_add_student)
       )
        return binding.root
    }
}