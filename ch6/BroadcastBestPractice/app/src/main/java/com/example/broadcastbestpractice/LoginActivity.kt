package com.example.broadcastbestpractice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val login: Button = findViewById(R.id.login)
        val accountEdit: EditText = findViewById(R.id.accountEdit)
        val passwordEdit: EditText = findViewById(R.id.passwordEdit)
        val rememberPass: CheckBox = findViewById(R.id.rememberPass)
        val presf = getPreferences(Context.MODE_PRIVATE)
        val isRemember = presf.getBoolean("remember_password", false)
        if (isRemember) {
            //將帳號和密碼都設置到文本框中
            val account = presf.getString("account", "")
            val password = presf.getString("password", "")
            accountEdit.setText(account)
            passwordEdit.setText(password)
            rememberPass.isChecked = true
        }
        login.setOnClickListener {
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
            if (account == "admin" && password == "123456") {
                val editor = presf.edit()
                if (rememberPass.isChecked) { //檢查複選框是否被選中
                    editor.putBoolean("remember_password", true)
                    editor.putString("account", account)
                    editor.putString("password", password)`
                } else {
                    editor.clear()
                }
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "account or password is invalid",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}
