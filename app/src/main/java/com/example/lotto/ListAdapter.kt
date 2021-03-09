package com.example.lotto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter (val context: Context, val dogList: ArrayList<Number>) : BaseAdapter() {
    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?) : View {
        var id=1
        val view: View = LayoutInflater.from(context).inflate(R.layout.activity_list_item, null)


        val id_txt = view.findViewById<TextView>(R.id.idtxt)
        val no1 = view.findViewById<ImageView>(R.id.imageView01)
        val no2 = view.findViewById<ImageView>(R.id.imageView02)
        val no3 = view.findViewById<ImageView>(R.id.imageView03)
        val no4 = view.findViewById<ImageView>(R.id.imageView04)
        val no5 = view.findViewById<ImageView>(R.id.imageView05)
        val no6 = view.findViewById<ImageView>(R.id.imageView06)

        id_txt.text = Integer.toString(id)


        no1.setImageResource(R.drawable.ball_01)
        id = id + 1


        return view
    }

}