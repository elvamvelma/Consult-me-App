package com.example.consultme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.share

class Share : AppCompatActivity() {
    var shared: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        shared = findViewById(R.id.mS)

        shared!!.setOnClickListener{
            share("Hi, Please visit consultme.com to download my app...")
        }
    }
    }
