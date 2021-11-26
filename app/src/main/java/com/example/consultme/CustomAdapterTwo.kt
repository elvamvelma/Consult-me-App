package com.example.consultme


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class CustomAdapterTwo(var context: Context, var data:ArrayList<User>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var mTxtName:TextView
        var mTxtAge:TextView
        var mTxtGender:TextView
        var mTxtEmail:TextView
        var mTxtPhone:TextView
        var mTxtPlace:TextView

        init {
            this.mTxtName = row?.findViewById(R.id.mTvName) as TextView
            this.mTxtAge = row?.findViewById(R.id.mTvAge) as TextView
            this.mTxtGender = row?.findViewById(R.id.mTvGender) as TextView
            this.mTxtEmail = row?.findViewById(R.id.mTvEmail) as TextView
            this.mTxtPhone = row?.findViewById(R.id.mTvPhone) as TextView
            this.mTxtPlace= row?.findViewById(R.id.mTvPlace) as TextView

        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.item_layout_two,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:User = getItem(position) as User
        viewHolder.mTxtName.text = item.name
        viewHolder.mTxtAge.text = item.age
        viewHolder.mTxtGender.text = item.gender
        viewHolder.mTxtEmail.text = item.email
        viewHolder.mTxtPhone.text = item.phone
        viewHolder.mTxtPlace.text = item.place


        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}
