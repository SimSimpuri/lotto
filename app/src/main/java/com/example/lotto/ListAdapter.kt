package com.example.lotto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

//리스트 어뎁터, LOttoNum 타입의 배열리스트를 받음
class ListAdapter (val context: Context, val List: ArrayList<LottoNum>) : BaseAdapter() {

    val lottoImageStartId2 = R.drawable.ball_01

    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?) : View {

        val view: View = LayoutInflater.from(context).inflate(R.layout.activity_list_item, null)


        val id_txt = view.findViewById<TextView>(R.id.idtxt)
        val date_text = view.findViewById<TextView>(R.id.datetv)
        val no1 = view.findViewById<ImageView>(R.id.imageView01)
        val no2 = view.findViewById<ImageView>(R.id.imageView02)
        val no3 = view.findViewById<ImageView>(R.id.imageView03)
        val no4 = view.findViewById<ImageView>(R.id.imageView04)
        val no5 = view.findViewById<ImageView>(R.id.imageView05)
        val no6 = view.findViewById<ImageView>(R.id.imageView06)

        var ln : LottoNum = List[position]

        id_txt.text = "${ln.id}"
        date_text.text = "${ln.date}"

        no1.setImageResource(lottoImageStartId2 + ln.n1-1)
        no2.setImageResource(lottoImageStartId2 + ln.n2-1)
        no3.setImageResource(lottoImageStartId2 + ln.n3-1)
        no4.setImageResource(lottoImageStartId2 + ln.n4-1)
        no5.setImageResource(lottoImageStartId2 + ln.n5-1)
        no6.setImageResource(lottoImageStartId2 + ln.n6-1)



        return view
    }

}