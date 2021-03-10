package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.DatePicker
import com.example.lotto.LottoNumberMaker.getLottoNumberconstell
import kotlinx.android.synthetic.main.activity_constell.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class ConstellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constell)

        //입력받은 월일로 별자리 반환하는 메소드
        fun makeConstellString(month: Int, day: Int): String{
            //달력으로 입력한 월일을 정수형으로 변경
            val constell = "${month+1}${String.format("%02d", day)}".toInt()

            when(constell){
                in 101..119 -> return "염소자리"
                in 120..218 -> return "물병자리"
                in 219..320 -> return "물고기자리"
                in 321..419 -> return "양자리"
                in 420..520 -> return "황소자리"
                in 521..621 -> return "쌍둥이자리"
                in 622..722 -> return "게자리"
                in 723..822 -> return "사자자리"
                in 823..923 -> return "처녀자리"
                in 924..1022 -> return "천칭자리"
                in 1023..1122 -> return "전갈자리"
                in 1123..1224 -> return "사수자리"
                in 1225..1231 -> return "염소자리"
                else -> return "기타별자리"

            }
        }

        //현재 월일로 텍스트뷰 별자리 문자열 변경
        constelltxt.text = makeConstellString(dataPicker.month, dataPicker.dayOfMonth)

        val calendar = Calendar.getInstance()
        dataPicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), object:CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener{
            //데이트피커 날짜 변경시 이벤트
            override fun onDateChanged(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                        //텍스트뷰 변경경
                       constelltxt.text = makeConstellString(dataPicker.month, dataPicker.dayOfMonth)
                    }

            override fun onSelectedDayChange(view: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
                TODO("Not yet implemented")
            }
        })


        goResultBt.setOnClickListener {
            intent = Intent(this, ResultActivity::class.java)

            //별자리로 만든 로또번호가 담긴 리스트와 별자리를 인텐트에 담아 결과 화면으로 이동
            intent.putIntegerArrayListExtra("result", ArrayList(getLottoNumberconstell(constelltxt.text.toString())))
            intent.putExtra("constell", constelltxt.text.toString())
            startActivity(intent)
        }
    }
}