package com.example.consultme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.firebase.database.FirebaseDatabase
import org.jetbrains.anko.email
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.sendSMS

class MainActivity2 : AppCompatActivity() {
    var editTextName: EditText? = null
    var editTextAge: EditText? = null
    var editTextGender: EditText? = null
    var editTextEmail: EditText? = null
    var editTextPhone: EditText? = null
    var editTextPlace: EditText? = null
    var buttonNext: Button? = null
    var buttonBack: Button? = null
    var buttonSave: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextName = findViewById(R.id.mName)
        editTextAge = findViewById(R.id.mAge)
        editTextGender = findViewById(R.id.mGender)
        editTextEmail = findViewById(R.id.mEmail)
        editTextPhone = findViewById(R.id.mPhone)
        editTextPlace = findViewById(R.id.mPlace)
        buttonSave = findViewById(R.id.mBack)


        buttonSave!!.setOnClickListener{
            //start receiving what the user has written on the input fields
            var name = editTextName!!.text.toString().trim()
            var age = editTextAge!!.text.toString().trim()
            var gender = editTextGender!!.text.toString().trim()
            var email = editTextEmail!!.text.toString().trim()
            var phone = editTextPhone!!.text.toString().trim()
            var place = editTextPlace!!.text.toString().trim()
            //check if the user is trying to submit to submit empty fields
            if (name.isEmpty()){
                editTextName!!.setError("Please fill this input")
                editTextName!!.requestFocus()

            }
            else if (age.isEmpty()){
                editTextAge!!.setError("Please fill this input")
                editTextAge!!.requestFocus()
            }
            else if (gender.isEmpty()){
                editTextGender!!.setError("Please fill this input")
                editTextGender!!.requestFocus()
            }
            else if (email.isEmpty()){
                editTextEmail!!.setError("Please fill this input")
                editTextEmail!!.requestFocus()
            }
            else if (phone.isEmpty()){
                editTextPhone!!.setError("Please fill this input")
                editTextPhone!!.requestFocus()
            }
            else if (place.isEmpty()){
                editTextPlace!!.setError("Please fill this input")
                editTextPlace!!.requestFocus()

            }


            else{
                var intent = Intent(this,MainPage::class.java)
                intent.putExtra("name",name)
                intent.putExtra("age",age)
                intent.putExtra("gender",gender)
                intent.putExtra("email",email)
                intent.putExtra("phone",phone)
                intent.putExtra("place",place)
                startActivity(intent)


            }

        }


    }


}




