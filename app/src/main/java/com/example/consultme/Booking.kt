package com.example.consultme

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale




class Booking : AppCompatActivity() {
    var one: CheckBox? = null
    var two: CheckBox? = null
    var three: CheckBox? = null
    var four: CheckBox? = null
    var five: CheckBox? = null
    var six: CheckBox? = null
    var booked: Button? = null
    var counter = 0
    var dataOne = "none"
    var dataTwo = "none"
    var dataThree = "none"
    var dataFour = "none"
    var dataFive = "none"
    var dataSix = "none"

    var mReceivedName = "none"
    var mReceivedAge = "none"
    var mReceivedGender = "none"
    var mReceivedEmail = "none"
    var mReceivedPhone = "none"
    var mReceivedPlace = "none"

    var myCalendar: Calendar?=null

    var edittext: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        one = findViewById(R.id.checkbox_one)

        two = findViewById(R.id.checkbox_two)
        three = findViewById(R.id.checkbox_three)
        four = findViewById(R.id.checkbox_four)
        five = findViewById(R.id.checkbox_five)
        six = findViewById(R.id.checkbox_six)
        booked = findViewById(R.id.book)

        mReceivedName = intent.getStringExtra("name").toString()
        mReceivedAge = intent.getStringExtra("age").toString()
        mReceivedGender = intent.getStringExtra("gender").toString()
        mReceivedEmail = intent.getStringExtra("email").toString()
        mReceivedPhone = intent.getStringExtra("phone").toString()
        mReceivedPlace = intent.getStringExtra("place").toString()


        myCalendar = Calendar.getInstance()

        edittext = findViewById(R.id.booking_date)

        val date =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth -> // TODO Auto-generated method stub
                myCalendar!!.set(Calendar.YEAR, year)
                myCalendar!!.set(Calendar.MONTH, monthOfYear)
                myCalendar!!.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateLabel()
            }

        edittext!!.setOnClickListener {
            DatePickerDialog(
                this@Booking, date, myCalendar!!
                    .get(Calendar.YEAR), myCalendar!!.get(Calendar.MONTH),
                myCalendar!!.get(Calendar.DAY_OF_MONTH)
            ).show()
        }




        one!!.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked == true) {
                counter++
                dataOne = "Radiology"
            } else {
                counter--
                dataOne = "none"
            }
        }

        two!!.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked == true) {
                counter++
                dataTwo = "Cardiology"
            } else {
                counter--
                dataTwo = "none"
            }
        }

        three!!.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked == true) {
                counter++
                dataThree = "Neurology"
            } else {
                counter--
                dataThree = "none"
            }
        }

        four!!.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked == true) {
                counter++
                dataFour = "Gynaecology"
            } else {
                counter--
                dataFour = "none"
            }
        }

        five!!.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked == true) {
                counter++
                dataFive = "Maternity"
            } else {
                counter--
                dataFive = "none"
            }
        }

        six!!.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked == true) {
                counter++
                dataSix = "Orthopedics"
            } else {
                counter--
                dataSix = "none"
            }
        }

        booked!!.setOnClickListener {
            var bookingDate = edittext!!.text.trim().toString()
            if (bookingDate.isEmpty()){
                edittext!!.setError("Please select a booking date")
                edittext!!.requestFocus()
            }else if (counter == 1) {
                if (!dataOne.equals("none")) {
                    booking(mReceivedName,mReceivedAge,mReceivedGender,mReceivedEmail,
                        mReceivedPhone,mReceivedPlace,dataOne,bookingDate)

                } else if (!dataTwo.equals("none")) {
                    booking(mReceivedName,mReceivedAge,mReceivedGender,mReceivedEmail,
                        mReceivedPhone,mReceivedPlace,dataTwo,bookingDate)
                } else if (!dataThree.equals("none")) {
                    booking(mReceivedName,mReceivedAge,mReceivedGender,mReceivedEmail,
                        mReceivedPhone,mReceivedPlace,dataThree,bookingDate)
                } else if (!dataFour.equals("none")) {
                    booking(mReceivedName,mReceivedAge,mReceivedGender,mReceivedEmail,
                        mReceivedPhone,mReceivedPlace,dataFour,bookingDate)
                } else if (!dataFive.equals("none")) {
                    booking(mReceivedName,mReceivedAge,mReceivedGender,mReceivedEmail,
                        mReceivedPhone,mReceivedPlace,dataFive,bookingDate)
                } else if (!dataSix.equals("none")) {
                    booking(mReceivedName,mReceivedAge,mReceivedGender,mReceivedEmail,
                        mReceivedPhone,mReceivedPlace,dataSix,bookingDate)
                }

            } else {
                Toast.makeText(this, "Sorry, select exactly one option", Toast.LENGTH_LONG).show()
            }

            if (one!!.isChecked) {var time = System.currentTimeMillis().toString()
                var ref = FirebaseDatabase.getInstance().getReference().child("Info/$time")
                var dataBeingSaved = Info(dataOne,time)
                ref.setValue(dataBeingSaved).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Radiology", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "", Toast.LENGTH_LONG).show()
                    }
                }

            }
            if (two!!.isChecked) {var time = System.currentTimeMillis().toString()
                var ref = FirebaseDatabase.getInstance().getReference().child("Info/$time")
                var dataBeingSaved = Info.InfoTwo(dataTwo,time)
                ref.setValue(dataBeingSaved).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Cardiology", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "", Toast.LENGTH_LONG).show()
                    }
                }

            }
            if (three!!.isChecked) {var time = System.currentTimeMillis().toString()
                var ref = FirebaseDatabase.getInstance().getReference().child("Info/$time")
                var dataBeingSaved = Info.InfoThree(dataThree,time)
                ref.setValue(dataBeingSaved).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Neurology", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "", Toast.LENGTH_LONG).show()
                    }
                }
            }
            if (four!!.isChecked) {var time = System.currentTimeMillis().toString()
                var ref = FirebaseDatabase.getInstance().getReference().child("Info/$time")
                var dataBeingSaved = Info.InfoFour(dataFour,time)
                ref.setValue(dataBeingSaved).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Gynecology", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "", Toast.LENGTH_LONG).show()
                    }
                }
            }
            if (five!!.isChecked) {var time = System.currentTimeMillis().toString()
                var ref = FirebaseDatabase.getInstance().getReference().child("Info/$time")
                var dataBeingSaved = Info.InfoFive(dataFive,time)
                ref.setValue(dataBeingSaved).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Maternity", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "", Toast.LENGTH_LONG).show()
                    }
                }
            }
            if (six!!.isChecked) {var time = System.currentTimeMillis().toString()
                var ref = FirebaseDatabase.getInstance().getReference().child("Info/$time")
                var dataBeingSaved = Info.InfoSix(dataSix,time)
                ref.setValue(dataBeingSaved).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Orthopedics", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "", Toast.LENGTH_LONG).show()
                    }
                }
            }

            }

    }

    fun booking(name:String,age:String,gender:String,email:String,phone:String,place:String,department:String,bookingDate:String){
        var dialog:ProgressDialog = ProgressDialog(this)
        dialog.setTitle("Booking")
        dialog.setMessage("Please wait...")
        var time = System.currentTimeMillis().toString()
        var ref = FirebaseDatabase.getInstance().getReference().child("Bookings/$time")
        var dataBeingSaved = Book(name,age,gender,email,phone,place,department,bookingDate,time)
        dialog.show()
        ref.setValue(dataBeingSaved).addOnCompleteListener{task->
            dialog.dismiss()
            if(task.isSuccessful){
                       Toast.makeText(this,"Booking submitted successfully", Toast.LENGTH_LONG).show()
                   }
                   else{
                       Toast.makeText(this,"Booking failed", Toast.LENGTH_LONG).show()
                   }
               }
    }

    private fun updateLabel() {
        val myFormat = "MM/dd/yy" //In which you need put here
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        edittext!!.setText(sdf.format(myCalendar!!.time))
    }

}


























