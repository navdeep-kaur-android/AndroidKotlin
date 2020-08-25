package com.managestudents.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.managestudents.R
import androidx.databinding.DataBindingUtil.setContentView
import com.managestudents.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}