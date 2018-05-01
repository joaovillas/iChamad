package com.example.matheusvillas.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBConnection(var context: Context):SQLiteOpenHelper(context,"iChamada",null,1){

    override fun onCreate(db: SQLiteDatabase?) {

        var table = "CREATE TABLE Professor (" +
                "  matricula VARCHAR(255)   NOT NULL ," +
                "  nome VARCHAR(255)   NOT NULL ," +
                "  telefone VARCHAR(255)    ," +
                "  senha VARCHAR(255)   NOT NULL   ," +
                "PRIMARY KEY(matricula));" +

                "CREATE TABLE Aluno ("+
                "  matricula VARCHAR(255)   NOT NULL ," +
                "  nome VARCHAR(255)   NOT NULL ," +
                "  telefone  VARCHAR(255)      ," +
                "PRIMARY KEY(matricula));" +

                "CREATE TABLE Turmas (" +
                "  idTurmas VARCHAR(255)   NOT NULL ," +
                "  Aluno_matricula VARCHAR(255)      ," +
                "PRIMARY KEY(idTurmas)  ," +
                "  FOREIGN KEY(Aluno_matricula)" +
                "    REFERENCES Aluno(matricula));" +

                "CREATE INDEX Turmas_FKIndex1 ON Turmas (Aluno_matricula);" +

                "CREATE INDEX IFK_Rel_10 ON Turmas (Aluno_matricula);" +

                "CREATE TABLE Notas (" +
                "  Aluno_matricula VARCHAR(255)   NOT NULL ," +
                "  nota_1 FLOAT   NOT NULL ," +
                "  nota_2 FLOAT   NOT NULL ," +
                "  nota_3 FLOAT      ," +
                "  FOREIGN KEY(Aluno_matricula)" +
                "    REFERENCES Aluno(matricula));" +

                "CREATE INDEX Notas_FKIndex1 ON Notas (Aluno_matricula);" +

                "CREATE INDEX IFK_Rel_12 ON Notas (Aluno_matricula);" +

                "CREATE TABLE Disciplina (" +
                "  idDisciplina VARCHAR(255)   NOT NULL ," +
                "  Turmas_idTurmas VARCHAR(255)   NOT NULL ," +
                "  Professor_matricula VARCHAR(255)   NOT NULL ," +
                "  nome VARCHAR(255)   NOT NULL ," +
                "  turmas VARCHAR(255)   NOT NULL   ," +
                "PRIMARY KEY(idDisciplina)    ," +
                "  FOREIGN KEY(Professor_matricula)" +
                "    REFERENCES Professor(matricula)," +
                "  FOREIGN KEY(Turmas_idTurmas)" +
                "    REFERENCES Turmas(idTurmas));" +

                "CREATE INDEX Disciplina_FKIndex1 ON Disciplina (Professor_matricula);" +
                "CREATE INDEX Disciplina_FKIndex2 ON Disciplina (Turmas_idTurmas);" +

                "CREATE INDEX IFK_Rel_08 ON Disciplina (Professor_matricula);" +
                "CREATE INDEX IFK_Rel_09 ON Disciplina (Turmas_idTurmas);"



            db?.execSQL(table)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertDB(professor: Professor){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put("matricula",professor.matricula)
        cv.put("nome",professor.nome)
        cv.put("senha",professor.telefone)

        var result = db.insert("Professor",null,cv)

        if (result ==-1.toLong())
            Toast.makeText(context,"Falha ao Inserir no Banco de Dados",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context , "Inserido com Sucesso",Toast.LENGTH_LONG).show()

    }

}
