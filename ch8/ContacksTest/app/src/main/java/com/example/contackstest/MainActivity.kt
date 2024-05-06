package com.example.contackstest

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val contactsList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactsView: ListView = findViewById(R.id.contactsView)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactsList)
        contactsView.adapter = adapter
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
        != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.READ_CONTACTS), 1)
        } else {
            readContacts()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty()
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readContacts()
                } else
                    Toast.makeText(this, "You denied the permission",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("Range")
    private fun readContacts() {
        //查詢聯絡人數據
        contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null, null, null, null)?.apply {
                while (moveToNext()) {
                    val displayName = getString(getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                    ))
                    //獲取聯絡人手機號碼
                    val number = getString(getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.NUMBER
                    ))
                    contactsList.add("$displayName\n$number")
                }
            adapter.notifyDataSetChanged()
            close()
        }
    }
}
