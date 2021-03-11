package com.example.lotto

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {

    lateinit var dbHelper : DBHelper
    lateinit var table : SQLiteDatabase

    val lottoImageStartId = R.drawable.ball_01

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //인텐트 받아오기
        val result = intent.getIntegerArrayListExtra("result")
        val name = intent.getStringExtra("name")
        val constell = intent.getStringExtra("constell")


        var NumArr = IntArray(6)


        //전달받은 결과가 있을 경우에만 실행
        result?.let {
            updateLottoBallImage(result.sortedBy{it})
            for(i in 0..5){
            NumArr[i] = result[i]
            }
        }


        //기본 텍스트뷰
        resultLable.text = "랜덤으로 생성된\n로또번호입니다"


        //이름이 전달된 경우
        if(!TextUtils.isEmpty(name)){
            resultLable.text = "${name}님의\n${SimpleDateFormat("yyyy년 MM월 dd일", Locale.KOREA).format(Date())}\n로또번호입니다"
        }else if(!TextUtils.isEmpty(constell)){
            resultLable.text = "${constell}의\n로또번호입니다"
        }



        //저장 버튼 클릭시
        storeBt.setOnClickListener {

            //로또번호를 저장할 SQLite DB 생성
            dbHelper = DBHelper(this, "newDB", null, 1)
            table = dbHelper.writableDatabase

            var contentValues = ContentValues()

            contentValues.put("date", SimpleDateFormat("yyyy.MM.dd", Locale.KOREA).format(Date()))
            for(i in 0..5){
                contentValues.put("n${i+1}", NumArr[i])
            }


            table.insert("lotto_table",null, contentValues)



            startActivity(Intent(this, MainActivity::class.java))
        }

        //메인으로 버튼 클릭시
        backBt2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }


    fun updateLottoBallImage(result: List<Int>) {
        if(result.size < 6) return

        imageView1.setImageResource(lottoImageStartId + (result[0]-1))
        imageView2.setImageResource(lottoImageStartId + (result[1]-1))
        imageView3.setImageResource(lottoImageStartId + (result[2]-1))
        imageView5.setImageResource(lottoImageStartId + (result[3]-1))
        imageView4.setImageResource(lottoImageStartId + (result[4]-1))
        imageView6.setImageResource(lottoImageStartId + (result[5]-1))

    }
}