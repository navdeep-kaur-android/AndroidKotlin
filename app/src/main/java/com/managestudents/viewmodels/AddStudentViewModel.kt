package com.managestudents.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.managestudents.data.Assignment


class AddStudentViewModel(application: Application) : AndroidViewModel(application) {
    private val assignmentsMutableList: MutableList<Assignment> = mutableListOf()
    private val assignmentsMutableLiveData = MutableLiveData<MutableList<Assignment>>()
    val assignmentsLiveData: LiveData<MutableList<Assignment>>
        get() = assignmentsLiveData


    fun addAssignmentToList(assignment: Assignment)
    {

        assignmentsMutableList.add(assignment)
        assignmentsMutableLiveData.value = assignmentsMutableList
    }
}