package com.managestudents.utilities

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Utilities {

    companion object {
        @SuppressLint("ShowToast")
        fun showToast(activity: AppCompatActivity, message:String){
           Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
       }
    }


}