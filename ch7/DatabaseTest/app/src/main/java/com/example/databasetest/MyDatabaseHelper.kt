package com.example.databasetest

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MyDatabaseHelper(private val context: Context, name: String, version: Int) :
        SQLiteOpenHelper(context, name, null, version) {
    private val createBook = "CREATE TABLE Book (" +
                             "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                             "author TEXT," +
                             "price REAL," +
                             "pages INTEGER," +
                             "name TEXT)"
    private val createCategory = "create table Category (" +
                                 "id integer primary key autoincrement," +
                                 "category_name text," +
                                 "category_code integer)"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createBook)
        db.execSQL(createCategory)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion <= 1) {
            db.execSQL(createCategory)
        }
    }
}