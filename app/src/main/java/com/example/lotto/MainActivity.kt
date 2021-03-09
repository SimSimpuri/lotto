package com.example.lotto

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var dbHelper : DBHelper
    lateinit var table : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun getRandomLottoNumber() : Int {

            return Random().nextInt(45)+1
        }

        fun getRandomLottoNumbers(): MutableList<Int>{
            val lottoNumbers = mutableListOf<Int>()

            for(i in 1..6){
                var num = 0
                do{
                    num = getRandomLottoNumber()
                }while (lottoNumbers.contains(num))

                lottoNumbers.add(num)
            }

            return lottoNumbers
        }



        dbHelper = DBHelper(this, "newDB", null, 1)
        table = dbHelper.writableDatabase

        rand.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            var list = ArrayList(getRandomLottoNumbers())

            System.out.println(list)

            intent.putExtra("result", ArrayList(list))

            startActivity(intent)
        }
        constell.setOnClickListener{
            startActivity(Intent(this@MainActivity, ConstellActivity::class.java))
        }

        name.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }

        store.setOnClickListener {
            startActivity(Intent(this@MainActivity, StoreActivity::class.java))
        }

        }
    }
