package com.managestudents.views

interface AddStudentView {
    fun onDataValidated()
    fun onError(message: String)
}