package com.nasuhcandurmaz.catchstankotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }




    fun start(view : View){
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        startActivity(intent)

    }



}