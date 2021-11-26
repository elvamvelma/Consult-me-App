package com.example.consultme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UsersActivity : AppCompatActivity() {
    var myListPeople: ListView? = null
    var users:ArrayList<User>? = null
    var adapter:CustomAdapterTwo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        myListPeople = findViewById(R.id.mListPeople)
        users = ArrayList()
        adapter = CustomAdapterTwo(this,users!!)

        var ref = FirebaseDatabase.getInstance().getReference().
        child("Users")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                users!!.clear()
                for (snap in snapshot.children){
                    var user = snap.getValue(User::class.java)
                    users!!.add(user!!)
                }
                adapter!!.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@UsersActivity,"DB locked", Toast.LENGTH_LONG).show()

            }
        })
        myListPeople!!.adapter = adapter

            }
    }
