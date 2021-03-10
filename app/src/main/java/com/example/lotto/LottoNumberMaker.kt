package com.example.lotto

import java.text.SimpleDateFormat
import java.util.*

object LottoNumberMaker {

    //무작위로 로또 번호를 생성하는 메소드
    fun getRandomLottoNumber() : Int {

        //Random 메소드를 사용해서 1부터 45까지 랜덤 숫자 반환
        return Random().nextInt(45)+1
    }

    fun getRandomLottoNumbers(): MutableList<Int>{

        //로또번호를 저장할 리스트 생성
        val lottoNumbers = mutableListOf<Int>()

        //리스트에 로또번호 6개 삽입
        for(i in 1..6){
            var num = 0
            do{
                num = getRandomLottoNumber()
            }while (lottoNumbers.contains(num)) //이미 있는 변수가 나오면 다시 번호 생성

            //중복이 없으면 리스트에 삽입
            lottoNumbers.add(num)
        }

        return lottoNumbers
    }


    //이름으로 로또번호 만드는 메소드
    fun getLottoNumberName(name: String): MutableList<Int>{
        val list = mutableListOf<Int>()


        for(i in 1..45){
            list.add(i) //1부터 45까지 리스트에 삽입
        }

        //이름 앞에 오늘 날짜 붙이기
        //SimpleDateFormat로 0000년 00월 00일 형태로 문자열 만듬
        val date_name = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + name

        //해시코드를 사용해서 입력한 이름이 같으면 같은 값 나오게 지정
        //앞에 날짜도 있으므로 내일 다른 번호가 나옴
        //shuffle()로 섞음
        list.shuffle(Random(date_name.hashCode().toLong()))

        //맨앞 6자리만 잘라서 리턴
        return list.subList(0, 6)
    }


    //별자리로 로또번호 만드는 메소드
    fun getLottoNumberconstell(constell: String): MutableList<Int>{
        val list = mutableListOf<Int>()


        for(i in 1..45){
            list.add(i) //1부터 45까지 리스트에 삽입
        }

        list.shuffle(Random(constell.hashCode().toLong()))

        //맨앞 6자리만 잘라서 리턴
        return list.subList(0, 6)
    }

}