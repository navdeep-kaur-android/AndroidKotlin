package com.managestudents.view

interface AddStudentView {
    fun onDataValidated()
    fun onError(message: String)
}