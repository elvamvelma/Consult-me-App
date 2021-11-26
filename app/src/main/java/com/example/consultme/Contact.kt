package com.example.consultme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.email
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.sendSMS

class Contact : AppCompatActivity() {
    var caller: Button? = null
    var messager: Button? = null
    var emailer: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        caller = findViewById(R.id.mPigia)
        messager = findViewById(R.id.mTuma)
        emailer = findViewById(R.id.mEmaili)

        caller!!.setOnClickListener{
            makeCall("0768841984")
        }
        messager!!.setOnClickListener {
            sendSMS("0768841984", "")
        }

        emailer!!.setOnClickListener {
            email("elvamvelma@gmail.com", "", "")
        }

    }
}