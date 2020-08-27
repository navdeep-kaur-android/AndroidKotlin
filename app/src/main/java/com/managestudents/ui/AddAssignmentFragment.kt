package com.managestudents.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.managestudents.R
import kotlinx.android.synthetic.main.fragment_add_assignment.view.*


class AddAssignmentFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val rootView = inflater.inflate(R.layout.fragment_add_assignment, container, false)
        setClickListener(rootView)
        return rootView
    }

    private fun setClickListener(rootView: View) {
        rootView.btn_addItem_cancel.setOnClickListener {
            dismiss()
        }
    }
}