package com.example.consultme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class Consult : AppCompatActivity() {
    var itemList : ListView? = null
    var items:ArrayList<Item>? = null
    var adapter:CustomAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consult)
        itemList = findViewById(R.id.mList)
        items = ArrayList()
        adapter = CustomAdapter(this,items!!)

        var item1 = Item(R.drawable.jane,"Dr.Jane","Care Hospital"
            )
        var item2 = Item(R.drawable.ram,"Dr.Ram","Matter Hospital"
        )
        var item3 = Item(R.drawable.peter,"Dr.Peter","St.John's Hospital"
        )
        var item4 = Item(R.drawable.mary,"Dr.Mary","Nairobi Hospital"
        )
        var item5 = Item(R.drawable.david,"Dr.David","Starehe Hospital"
        )


        items!!.add(item1)
        items!!.add(item2)
        items!!.add(item3)
        items!!.add(item4)
        items!!.add(item5)

        itemList!!.adapter = adapter
    }
}