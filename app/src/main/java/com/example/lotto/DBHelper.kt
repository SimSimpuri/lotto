package com.example.lotto

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
        context: Context?,
        name: String?,
        factory: SQLiteDatabase.CursorFactory?,
        version: Int
        ): SQLiteOpenHelper(context, name, factory, version) {

            override fun onCreate(db: SQLiteDatabase){
                var sql : String = "create table if not exists lotto_table (" +
                        "id Integer primary key autoincrement, day Text," +
                        "n1 Integer not null, n2 Integer not null, n3 Integer not null, n4 Integer not null,"+
                        "n5 Integer not null, n6 Integer not null);"
                db.execSQL(sql)
            }

            override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int){
                var sql : String = "DROP TABLE if exists lotto_table;"
                db.execSQL(sql)
                onCreate(db)
            }
}