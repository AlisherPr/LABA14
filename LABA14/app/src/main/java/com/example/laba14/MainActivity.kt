package com.example.laba14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this, Final::class.java)
            startActivity(intent)
        }
    }
    /*Функция для работы в отдельном потоке*//*
    @Throws(IOException::class)
    fun httpRequest(urlString: String):String {
        *//*Созддание экземпляра URL*//*
        val url = URL(urlString)
        *//*Создание экзепляра класса для соедниения по протоколу HTTP*//*
        val connection = url.openConnection() as HttpURLConnection
        *//*Установка метода запроса*//*
        connection.requestMethod = "GET"
        *//*Отправка запроса и чтение полученых данных*//*
        var data: Int = connection.inputStream.read()
        var str = ""
        while (data != -1){
            str += data.toChar()
            data = connection.inputStream.read()
        }
        return str
    }*/
}