package com.example.matheusvillas.myapplication

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText


class DBConnection(var context: Context) :
        SQLiteOpenHelper(context,"iChamada" ,
                null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int,
                           newVersion: Int) {

    }

    fun insert_(professor:Professor){
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put("matricula",professor.matricula)
        cv.put("nome", professor.nome)
        cv.put("telefone",professor.telefone)
        var result = db.insert("Professor",null , cv)

        if(result==-1.toLong()){
             Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()
        }
    }


}
﻿