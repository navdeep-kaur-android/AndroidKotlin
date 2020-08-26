package com.managestudents.data

class StudentRepository(private val studentDao: StudentDao)  {

    fun getAllStudents() = studentDao.getAllStudents()
    fun getStudent(studentID : Int) = studentDao.getStudent(studentID)
    fun searchStudents(name : String) = studentDao.searchStudents(name)
    fun addStudent(student : Student) = studentDao.addStudent(student)
    fun deleteStudent(id : Int) = studentDao.deleteStudent(id)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: StudentRepository? = null

        fun getInstance(studentDao: StudentDao) =
            instance ?: synchronized(this) {
                instance ?: StudentRepository(studentDao).also { instance = it }
            }
    }
}