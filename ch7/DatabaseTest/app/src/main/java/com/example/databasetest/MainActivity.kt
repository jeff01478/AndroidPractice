package com.example.databasetest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.lang.Exception
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val createDatabase: Button = findViewById(R.id.createDatabase)
        val addData: Button = findViewById(R.id.addData)
        val updateData: Button = findViewById(R.id.updateData)
        val deleteData: Button = findViewById(R.id.deleteData)
        val queryData: Button = findViewById(R.id.queryData)
        val replaceData: Button = findViewById(R.id.replaceData)
        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 2 )
        createDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }
        addData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values1 = ContentValues().apply {
                put("name", "The Da Vinci Code")
                put("author", "Dan Brown")
                put("pages", 454)
                put("price", 16.96)
            }
            db.insert("Book", null, values1)
            val value2 = ContentValues().apply {
                put("name", "The Lost Symbol")
                put("author", "Dan Brown")
                put("pages", 510)
                put("price", 19.95)
            }
            db.insert("Book", null, value2)
        }
        updateData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("price", "10.99")
            db.update("Book", values, "name = ?", arrayOf("The Da Vinci Code"))
        }
        deleteData.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.delete("Book", "pages > ?", arrayOf("500"))
        }
        queryData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val cursor = db.query("Book", null, null, null, null, null, null)
            if(cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val pages = cursor.getInt(cursor.getColumnIndex("pages"))
                    val price = cursor.getDouble(cursor.getColumnIndex("price"))
                    Log.d("GOOD", "book name is $name")
                    Log.d("GOOD", "book author is $author")
                    Log.d("GOOD", "book pages is $pages")
                    Log.d("GOOD", "book price is $price")
                } while (cursor.moveToNext())
            }
            cursor.close()
        }
        replaceData.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.beginTransaction() //開啟事務
            try {
                db.delete("Book", null, null)
                if (true) {
                    //throw NullPointerException()
                }
                val value = ContentValues().apply {
                    put("name", "Game of Thrones")
                    put("author", "George Martins")
                    put("pages", 720)
                    put("price", 20.85)
                }
                db.insert("Book", null, value)
                db.setTransactionSuccessful() //事務已執行成功
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                db.endTransaction() //結束事務
            }
        }
    }
}
