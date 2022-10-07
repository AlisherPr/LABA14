package com.example.laba14

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Final : AppCompatActivity() {
    private lateinit var TextView: TextView
    private lateinit var button: Button
    private lateinit var back: Button
    private lateinit var off:Button
    private lateinit var weak:Button
    private lateinit var normal:Button
    private lateinit var full:Button
    private lateinit var color0: Button
    private lateinit var color1:Button
    private lateinit var color2:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        TextView = findViewById(R.id.textView)
        back = findViewById(R.id.back)
        off = findViewById(R.id.button3)
        weak = findViewById(R.id.button5)
        normal = findViewById(R.id.button6)
        full = findViewById(R.id.button7)
        color0 = findViewById(R.id.button4)
        color1 = findViewById(R.id.button8)
        color2 = findViewById(R.id.button9)


        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        /*Инициальизация исполнителя для потока*/
        val executorService: ExecutorService = Executors.newSingleThreadExecutor()

        off.setOnClickListener {
            //*получение данных из потока для отображения в textView*//*
            TextView.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/room/light/poweron/0")
            }).get()
        }
        weak.setOnClickListener {
            //*получение данных из потока для отображения в textView*//*
            TextView.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/room/light/poweron/1")
            }).get()
        }
        normal.setOnClickListener {
            //*получение данных из потока для отображения в textView*//*
            TextView.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/room/light/poweron/2")
            }).get()
        }
        full.setOnClickListener {
            //*получение данных из потока для отображения в textView*//*
            TextView.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/room/light/poweron/3")
            }).get()
        }
        color0.setOnClickListener {
            //*получение данных из потока для отображения в textView*//*
            TextView.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/room/light/setcolor/0")
            }).get()
        }
        color1.setOnClickListener {
            //*получение данных из потока для отображения в textView*//*
            TextView.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/room/light/setcolor/1")
            }).get()
        }
        color2.setOnClickListener {
            //*получение данных из потока для отображения в textView*//*
            TextView.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/room/light/setcolor/2")
            }).get()
        }

    }
    /*Функция для работы в отдельном потоке*/
    @Throws(IOException::class)
    fun httpRequest(urlString: String):String {
        /*Созддание экземпляра URL*/
        val url = URL(urlString)
        /*Создание экзепляра класса для соедниения по протоколу HTTP*/
        val connection = url.openConnection() as HttpURLConnection
        /*Установка метода запроса*/
        connection.requestMethod = "GET"
        /*Отправка запроса и чтение полученых данных*/
        var data: Int = connection.inputStream.read()
        var str = ""
        while (data != -1){
            str += data.toChar()
            data = connection.inputStream.read()
        }


        return str
    }
}