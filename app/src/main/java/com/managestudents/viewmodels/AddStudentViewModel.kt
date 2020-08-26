package com.managestudents.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.managestudents.data.Student
import com.managestudents.data.StudentDatabase
import com.managestudents.data.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddStudentViewModel(application: Application) : AndroidViewModel(application) {
    val repository: StudentRepository
    val students: LiveData<List<Student>>

    init {
        val studentDao = StudentDatabase.getInstance(application).studentDao()
        repository = StudentRepository(studentDao)
        students = repository.getAllStudents()
    }

    /**
     * method to add student to database
     */
    fun addStudent(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.addStudent(student)
    }
}