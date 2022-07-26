package com.example.anrstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.math.sqrt
import kotlin.random.Random

// ANR => Android Not Responding
// 네트워크 요청 보내기 가정
// 3초 정도 걸린다고 가정
// 데이터베이스에 데이터를 가져오는 것도 ANR 유발 가능
//arr 버튼을 누르면 계산이 이루어지는 데 계산이 이루어지는 스레드는 메인쓰레드(=UI스레드)임
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result = findViewById<TextView>(R.id.result)
//Toast 메시지 -> 화면에 띄우는 메시지
        findViewById<Button>(R.id.btn).setOnClickListener{
            Toast.makeText(this,
            "Clicked!",
            Toast.LENGTH_SHORT).show()
        }

        //메인 스레드(=UI스레드)에서는 짧은 시간에 끝나는 코드나 UI 조작 코드만 쓰고,
        //만약 오래 걸리는 작업이 있으면 해당 코드는 스레드를 새로 만들어서 위임해야 한다.
        // (+만약 새로 만든 스레드에서 UI 작업을 하는 것은 허용되지 않음)]
        // AsyncTask <= 대신 코루틴(coroutine)을 사용
        findViewById<Button>(R.id.anr).setOnClickListener{
            Thread(Runnable {
                var sum = 0.0
                    for(i in 1..60){
                        sum += sqrt(Random.nextDouble())
                        Thread.sleep(100)
                    }
                Log.d("mytag",sum.toString())
                runOnUiThread{
                    result.text = sum.toString()
                }
                }).start()
        }
    }
}