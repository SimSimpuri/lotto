package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rand.setOnClickListener {
            startActivity(Intent(this@MainActivity, RandomActivity::class.java))
        }
        constell.setOnClickListener{
            startActivity(Intent(this@MainActivity, ConstellActivity::class.java))
        }

        name.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }

        }



    }
