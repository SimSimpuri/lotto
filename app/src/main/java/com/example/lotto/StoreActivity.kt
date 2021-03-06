package com.example.lotto

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_item.*
import kotlinx.android.synthetic.main.activity_store.*

class StoreActivity : AppCompatActivity() {

    lateinit var dbHelper : DBHelper
    lateinit var table : SQLiteDatabase

    fun CreateListview(c: Cursor, list: ArrayList<LottoNum>) {
        while(c.moveToNext()){
            var lo = LottoNum(c.getInt(c.getColumnIndex("id")), c.getInt(c.getColumnIndex("n1")), c.getInt(c.getColumnIndex("n2")),
                    c.getInt(c.getColumnIndex("n3")), c.getInt(c.getColumnIndex("n4")), c.getInt(c.getColumnIndex("n5")),
                    c.getInt(c.getColumnIndex("n6")), c.getString(c.getColumnIndex("day")))


            list.add(lo)

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        dbHelper = DBHelper(this, "newDB", null, 1)
        table = dbHelper.writableDatabase


        var c : Cursor = table.query("lotto_table",null,null,null,null,null,null)
        var list = arrayListOf<LottoNum>()


        CreateListview(c, list)

        val adapter = ListAdapter(this, list)
        mainListView.adapter = adapter

        mainListView.deferNotifyDataSetChanged()

        backBt3.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }



    }
}