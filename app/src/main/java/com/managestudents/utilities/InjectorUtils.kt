package com.managestudents.utilities

import android.content.Context
import com.managestudents.data.StudentDatabase
import com.managestudents.data.StudentRepository

object InjectorUtils {
    private fun getStudentRepository(context: Context): StudentRepository {
        return StudentRepository.getInstance(
            StudentDatabase.getInstance(context.applicationContext).studentDao())
    }
//    fun provideAddStudentViewModelFactory(
//        context: Context,
//        student: Student
//    ): AddStudentViewModelFactory {
//        return AddStudentViewModelFactory(getStudentRepository(context),
//            getGardenPlantingRepository(context), plantId)
//    }
}