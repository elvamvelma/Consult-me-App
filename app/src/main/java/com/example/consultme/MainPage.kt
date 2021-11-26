package com.example.consultme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainPage : AppCompatActivity() {

    var accountCard: CardView? = null
    var appointmentCard: CardView? = null
    var contactCard: CardView? = null
    var ShareCard: CardView? = null
    var visitCard: CardView? = null

    var mReceivedName = "none"
    var mReceivedAge = "none"
    var mReceivedGender = "none"
    var mReceivedEmail = "none"
    var mReceivedPhone = "none"
    var mReceivedPlace = "none"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        accountCard = findViewById(R.id.account)
        appointmentCard = findViewById(R.id.appointment)
        visitCard = findViewById(R.id.visitation)
        contactCard = findViewById(R.id.contacts)
        ShareCard = findViewById(R.id.shares)

        mReceivedName = intent.getStringExtra("name").toString()
        mReceivedAge = intent.getStringExtra("age").toString()
        mReceivedGender = intent.getStringExtra("gender").toString()
        mReceivedEmail = intent.getStringExtra("email").toString()
        mReceivedPhone = intent.getStringExtra("phone").toString()
        mReceivedPlace = intent.getStringExtra("place").toString()




        accountCard!!.setOnClickListener {
            startActivity(Intent(this, Consult::class.java))
        }
        appointmentCard!!.setOnClickListener {

            var intent = Intent(this,Booking::class.java)
            intent.putExtra("name",mReceivedName)
            intent.putExtra("age",mReceivedAge)
            intent.putExtra("gender",mReceivedGender)
            intent.putExtra("email",mReceivedEmail)
            intent.putExtra("phone",mReceivedPhone)
            intent.putExtra("place",mReceivedPlace)
            startActivity(intent)
        }
        visitCard!!.setOnClickListener {
            startActivity(Intent(this, Visit::class.java))
        }
        contactCard!!.setOnClickListener {
            startActivity(Intent(this, Contact::class.java))
        }


        ShareCard!!.setOnClickListener {
            startActivity(Intent(this, Share::class.java))
        }


    }
}