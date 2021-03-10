package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.widget.Toast
import com.example.lotto.LottoNumberMaker.getLottoNumberName
import kotlinx.android.synthetic.main.activity_name.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)


        goResultbt.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)

            if(TextUtils.isEmpty(NameEdt.text.toString())) {
                Toast.makeText(this, "이름을 입력해 주세요", Toast.LENGTH_SHORT).show()
            }
            else {
                //로또번호 리스트와 이름을 결과 화면으로 인텐트
                intent.putIntegerArrayListExtra("result", ArrayList(getLottoNumberName(NameEdt.text.toString())))
                intent.putExtra("name", NameEdt.text.toString())
                startActivity(intent)
            }
        }

        //뒤로가기 버튼
        backBt.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        NameEdt.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KEYCODE_ENTER) {
                goResultbt.callOnClick()
            }
            true
        }



    }
}