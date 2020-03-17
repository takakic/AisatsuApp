package com.example.aisatsuapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.app.TimePickerDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener{
            Log.d("UI_PARTS", "ボタンを押しました")
            showTimePickerDialog()

        }

    }

    private fun showTimePickerDialog(){
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener{
                    view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                //var time = hour.toString() + ":" + minute.toString()
                //textView1.text = time
            doAisatsu(hour, minute)


            },
            13,0, true)
        timePickerDialog.show()

    }

    private fun doAisatsu(hour: Int, minute: Int){
        // 2:00-9:59 おはよう
        // 10:00-17:59 こんにちは
        // 18:00-1:59 こんばんは

        if (2 <= hour && hour <= 9){
            textView1.text = "おはよう"
        }else if (10 <= hour && hour <= 17){
            textView1.text = "こんにちは"
        }else if (18 <= hour && hour <= 24 || hour <= 1){
            textView1.text = "こんばんは"
        }
    }

}
