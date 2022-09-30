package com.codetron.myviewmodel

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        findViewById<View>(android.R.id.content).setOnClickListener {
            viewModel.number += 1
            findViewById<TextView>(R.id.text_hello).text = viewModel.number.toString()
        }

        findViewById<TextView>(R.id.text_hello).text = viewModel.number.toString()

        Toast.makeText(this, "instance: $viewModel", Toast.LENGTH_SHORT).show()
    }
}

class MainViewModel : ViewModel() {
    var number = 0
}