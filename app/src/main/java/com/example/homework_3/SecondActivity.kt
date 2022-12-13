package com.example.homework_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        fun average() {
//            val avg = randomList.average()
//
//        }
        fun onClick (view: View) {
            val i = Intent ()
    i.putExtra("key1", "done")
setResult(RESULT_OK, i)
    finish()
        }
    }


}