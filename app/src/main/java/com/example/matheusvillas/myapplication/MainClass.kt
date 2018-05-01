package com.example.matheusvillas.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_class.*

class MainClass : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class)

        var context = this
        btn_insert.setOnClickListener({
            if(etvMatricula.text.toString().length>0 && etvTelefone.text.toString().length>0 && etvNome.text.toString().length>0 ){
                var professor = Professor(etvMatricula.toString(),etvNome.toString(),etvTelefone.toString())
                var db = DBConnection(context)
                db.insertDB(professor)

            }else{
                Toast.makeText(this,"Por favor insira os campos corretamente",Toast.LENGTH_LONG).show()
            }

        })


    }
}
