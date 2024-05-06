package com.example.android_training

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView
import android.widget.AbsListView.MultiChoiceModeListener
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initList()
        val testListView: ListView = findViewById(R.id.testListView)
        val adapter = NoteAdapter2(this, R.layout.list_item2, list)
        testListView.adapter = adapter
        testListView.choiceMode = ListView.CHOICE_MODE_MULTIPLE_MODAL
//        val callback = ModeCallback()
        testListView.setOnItemClickListener { _, _, position, _ ->

        }
        testListView.setMultiChoiceModeListener(object : AbsListView.MultiChoiceModeListener {
            override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                Log.d("GOOD", "onCreateActionMode")
                return true
            }

            override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                Log.d("GOOD", "onPrepareActionMode")
                return true
            }

            override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                Log.d("GOOD", "onActionItemClicked")
                return true
            }

            override fun onDestroyActionMode(p0: ActionMode?) {
                Log.d("GOOD", "onDestroyActionMode")
            }

            override fun onItemCheckedStateChanged(p0: ActionMode?, p1: Int, p2: Long, p3: Boolean) {
                Log.d("GOOD", "onItemCheckedStateChanged")
            }
        })

//        testListView.setOnItemLongClickListener { _, _, position, _ ->
//            val adapter2 = NoteAdapter2(this, R.layout.list_item2, list)
//            testListView.adapter = adapter2
//            testListView.choiceMode = ListView.CHOICE_MODE_MULTIPLE_MODAL
//            true
//        }

    }

//    class ModeCallback : MultiChoiceModeListener {
//        override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
//            Log.d("GOOD", "onCreateActionMode")
//            return true
//        }
//
//        override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
//            Log.d("GOOD", "onPrepareActionMode")
//            return true
//        }
//
//        override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
//            Log.d("GOOD", "onActionItemClicked")
//            return true
//        }
//
//        override fun onDestroyActionMode(p0: ActionMode?) {
//            Log.d("GOOD", "onDestroyActionMode")
//        }
//
//        override fun onItemCheckedStateChanged(p0: ActionMode?, p1: Int, p2: Long, p3: Boolean) {
//            Log.d("GOOD", "onItemCheckedStateChanged")
//        }
//
//    }

    private fun initList() {
        list.add(Note(0, "A", "a"))
        list.add(Note(1, "B", "b"))
        list.add(Note(2, "C", "c"))
        list.add(Note(3, "D", "d"))
        list.add(Note(4, "E", "e"))
        list.add(Note(5, "F", "f"))
    }
}
