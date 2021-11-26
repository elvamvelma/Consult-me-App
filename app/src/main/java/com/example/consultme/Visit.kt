package com.example.consultme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class Visit : AppCompatActivity() {
    var list: ListView? = null
    var items: ArrayList<ItemThree>? = null
    var adapter: CustomAdapterThree? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visit)

        list = findViewById(R.id.mHospitals)
        items = ArrayList()
        adapter = CustomAdapterThree(this, items!!)

        var item1 = ItemThree(R.drawable.imgs, "Care Hospital", "Nairobi", "0768841984")

        var item2 = ItemThree(R.drawable.img, "St.John Hospital", "Nairobi", "0768841984")

        items!!.add(item1)
        items!!.add(item2)

        list!!.adapter = adapter
    }
}
