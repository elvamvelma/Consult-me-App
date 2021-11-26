package com.example.consultme

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class CustomAdapter(var context: Context, var data:ArrayList<Item>):BaseAdapter() {
    private class ViewHolder(row: View?) {
        var mTxtName: TextView
        var mTxtDesc: TextView
        var mItemPhoto: ImageView
        var mBtnConsult: Button


        private val PERMISSION_CODE = 1000;

        init {
            this.mTxtName = row?.findViewById(R.id.mNames) as TextView
            this.mItemPhoto = row?.findViewById(R.id.mPic) as ImageView
            this.mTxtDesc = row?.findViewById(R.id.mHosp) as TextView
            this.mBtnConsult = row?.findViewById(R.id.mCall) as Button


        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.item_layout, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item: Item = getItem(position) as Item
        viewHolder.mTxtName.text = item.name
        viewHolder.mTxtDesc.text = item.desc
        viewHolder.mItemPhoto.setImageResource(item.photo)
        viewHolder.mBtnConsult.setOnClickListener {
            context.startActivity(Intent(context,Talk::class.java))
        }

        return view as View

    }


    override fun getItem(position: Int): Any {
        return data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}


