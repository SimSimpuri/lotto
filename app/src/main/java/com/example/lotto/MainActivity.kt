package com.example.lotto

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lotto.LottoNumberMaker.getRandomLottoNumbers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var dbHelper : DBHelper
    lateinit var table : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //로또번호를 저장할 SQLite DB 생성
        dbHelper = DBHelper(this, "newDB", null, 1)
        table = dbHelper.writableDatabase

        //랜덤으로 생성 클릭시
        rand.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)

            //랜덤 번호 생성 메소드를 사용해 리스트에 삽입
            var list = ArrayList(getRandomLottoNumbers())


            //인텐트로 로또번호 리스트 담아서 결과화면으로 이동
            intent.putExtra("result", ArrayList(list))
            startActivity(intent)
        }

        //별자리 화면으로 이동
        constell.setOnClickListener{
            startActivity(Intent(this@MainActivity, ConstellActivity::class.java))
        }

        //이름 화면으로 이동
        name.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }

        //저장소 화면으로 이동
        store.setOnClickListener {
            startActivity(Intent(this@MainActivity, StoreActivity::class.java))
        }

        }
    }
