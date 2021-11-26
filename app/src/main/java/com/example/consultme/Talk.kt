package com.example.consultme

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import org.jetbrains.anko.email
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.sendSMS

class Talk : AppCompatActivity() {
    var calling: Button? = null
    var messaging: Button? = null
    var emailing: Button? = null
    var counter = 0
    var dataTen = "none"
    var dataTwenty = "none"
    var dataThirty = "none"

    private var PERMISSION_CODE = 1000;
    private var IMAGE_CAPTURE_CODE = 1001
    var image_uri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talk)

        calling = findViewById(R.id.Phone)
        messaging = findViewById(R.id.Sms)
        emailing = findViewById(R.id.Email)


        calling!!.setOnClickListener {
            makeCall("0768841984")

            if (calling!!.isClickable == true) {
                counter++
                dataTen = "calling"
            } else {
                counter--
                dataTen = "none"
            }
            if (calling!!.isClickable) {
                var times = System.currentTimeMillis().toString()
                var ref = FirebaseDatabase.getInstance().getReference().child("Consultations/$times")
                var dataBeingSaved = Consultations(dataTen, times)
                ref.setValue(dataBeingSaved).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Calling", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }


            messaging!!.setOnClickListener {
                sendSMS("0768841984", "")

                if (messaging!!.isClickable == true) {
                    counter++
                    dataTwenty = "messaging"
                } else {
                    counter--
                    dataTwenty = "none"
                }
                if (messaging!!.isClickable) {
                    var times = System.currentTimeMillis().toString()
                    var ref = FirebaseDatabase.getInstance().getReference().child("Consultations/$times")
                    var dataBeingSaved = Consultations.ConsultTwo(dataTwenty, times)
                    ref.setValue(dataBeingSaved).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "messaging", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }

            emailing!!.setOnClickListener {
                email("elvamvelma@gmail.com", "", "")

                if (emailing!!.isClickable == true) {
                    counter++
                    dataThirty = "emailing"
                } else {
                    counter--
                    dataThirty = "none"
                }
                if (emailing!!.isClickable) {
                    var times = System.currentTimeMillis().toString()
                    var ref = FirebaseDatabase.getInstance().getReference().child("Consultations/$times")
                    var dataBeingSaved = Consultations.ConsultThree(dataThirty, times)
                    ref.setValue(dataBeingSaved).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "emailing", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }

        }
        }

