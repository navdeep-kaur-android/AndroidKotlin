package com.managestudents.presenter

interface AddStudentPresenter {
    fun validateData(name: String, courseName: String, email: String, phoneNumber: String)
}