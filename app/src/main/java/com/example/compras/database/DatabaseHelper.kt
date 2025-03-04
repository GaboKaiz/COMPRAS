package com.example.compras.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "usuarios.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "usuarios"
        private const val COLUMN_ID = "id"
        private const val COLUMN_CORREO = "correo"
        private const val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_CORREO TEXT UNIQUE, " +
                "$COLUMN_PASSWORD TEXT)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // Método para registrar un usuario
    fun registrarUsuario(correo: String, password: String): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_CORREO, correo)
        values.put(COLUMN_PASSWORD, password)

        return try {
            db.insertOrThrow(TABLE_NAME, null, values)
            db.close()
            true
        } catch (e: Exception) {
            db.close()
            false
        }
    }

    // Método para verificar el inicio de sesión
    fun validarUsuario(correo: String, password: String): Boolean {
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_CORREO = ? AND $COLUMN_PASSWORD = ?"
        val cursor = db.rawQuery(query, arrayOf(correo, password))

        val existe = cursor.count > 0
        cursor.close()
        db.close()

        return existe
    }
}
