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
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class CustomAdapterThree(var context: Context, var data: ArrayList<ItemThree>):BaseAdapter() {
    private class ViewHolder(row: View?) {
        var mName: TextView
        var mLocate: TextView
        var mPhoto: ImageView
        var mBtnContact: Button

        private val PERMISSION_CODE = 1000;

        init {
            this.mName = row?.findViewById(R.id.mNames) as TextView
            this.mLocate = row?.findViewById(R.id.mHosp) as TextView
           this.mPhoto = row?.findViewById(R.id.mPicture) as ImageView
            this.mBtnContact = row?.findViewById(R.id.mCalls) as Button

        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.item_layout_three, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item: ItemThree = getItem(position) as ItemThree
        viewHolder.mName.text = item.name
        viewHolder.mLocate.text = item.location
        viewHolder.mPhoto.setImageResource(item.photo)
        viewHolder.mBtnContact.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "${item.phone}"))
            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                context.startActivity(intent)
            }
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



