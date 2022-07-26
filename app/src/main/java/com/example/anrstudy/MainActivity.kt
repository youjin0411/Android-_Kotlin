package com.example.anrstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlin.math.sqrt
import kotlin.random.Random

// ANR => Android Not Responding
// 네트워크 요청 보내기 가정
// 3초 정도 걸린다고 가정
// 데이터베이스에 데이터를 가져오는 것도 ANR 유발 가능

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Toast 메시지 -> 화면에 띄우는 메시지
        findViewById<Button>(R.id.btn).setOnClickListener{
            Toast.makeText(this,
            "Clicked!",
            Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.anr).setOnClickListener{
            for(i in 1..Int.MAX_VALUE){
                Log.d("mytag", sqrt(Random.nextDouble()).toString())
            }
        }
    }
}