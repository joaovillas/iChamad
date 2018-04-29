package com.example.matheusvillas.myapplication

import android.database.sqlite.SQLiteOpenHelper
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_class.*

class MainClass : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class)

        btn_insert.setOnClickListener({
            if(input_matricula.text.toString().length>0 && input_nome.text.toString().length>0 && input_tel.text.toString().length>0 ){

            }else{
                Toast.makeText(this,"Por favor insira os campos corretamente",Toast.LENGTH_LONG)
            }

        })


    }
}
