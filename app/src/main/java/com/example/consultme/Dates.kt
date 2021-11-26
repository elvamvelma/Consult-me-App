package com.example.consultme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class Dates : AppCompatActivity() {
    var selectedDepartment: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dates)

        selectedDepartment = findViewById(R.id.book)

        var selectedDepartment: String = intent.getStringExtra("data").toString()
        Toast.makeText(this, selectedDepartment, Toast.LENGTH_LONG).show()

    }
}