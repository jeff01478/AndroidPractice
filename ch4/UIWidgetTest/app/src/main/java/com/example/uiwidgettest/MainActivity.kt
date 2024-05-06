package com.example.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var good = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val editText: EditText = findViewById(R.id.editText)
        val imageView: ImageView = findViewById(R.id.imageView)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        button.setOnClickListener {
            AlertDialogTest()
        }
    }

    fun AlertDialogTest() {
        AlertDialog.Builder(this).apply {
            setTitle("ERROR: 444444444444444")
            setMessage("發生不可預期錯誤")
            setCancelable(false)
            setPositiveButton("回報錯誤") { dialog, which ->
                good++
                if (good == 10)
                    finish()
                AlertDialogTest()
            }
            setNegativeButton("關閉應用程式") {dialog, which ->
                good++
                if (good == 10)
                    finish()
                AlertDialogTest()
            }
            show()
        }
    }
}