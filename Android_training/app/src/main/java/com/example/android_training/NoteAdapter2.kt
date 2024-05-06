package com.example.android_training

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

class NoteAdapter2(activity: Activity, val resourceId: Int, data: List<Note>) :
    ArrayAdapter<Note>(activity, resourceId, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(resourceId, parent, false)
        val noteTitle: TextView = view.findViewById(R.id.noteTitle)
        val noteContent: TextView = view.findViewById(R.id.noteContent)
//        val checkBox: CheckBox = view.findViewById(R.id.checkBox)
        val note = getItem(position)
        if (note != null) {
            noteTitle.text = note.title
            noteContent.text = note.content
        }
        return view
    }
}