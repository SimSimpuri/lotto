package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    val lottoImageStartId = R.drawable.ball_01

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntegerArrayListExtra("result")


        result?.let {
            updateLottoBallImage(result.sortedBy{it})
        }

        storeBt.setOnClickListener {


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