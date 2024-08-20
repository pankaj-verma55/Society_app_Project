package com.example.socityapppankaj

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoticeBoard : AppCompatActivity() {
    private val noticeList = mutableListOf<Notice.Notice>()
    private lateinit var noticeAdapter: NoticeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notice_board)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        noticeAdapter = NoticeAdapter(noticeList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = noticeAdapter

        fab.setOnClickListener {
            showAddNoticeDialog()
        }
    }

    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    private fun showAddNoticeDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_notice, null)
        val etTitle: EditText = dialogView.findViewById(R.id.etTitle)
        val etContent: EditText = dialogView.findViewById(R.id.etContent)

        AlertDialog.Builder(this)
            .setTitle("Add New Notice")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val title = etTitle.text.toString()
                val content = etContent.text.toString()
                if (title.isNotEmpty() && content.isNotEmpty()) {
                    val notice = Notice.Notice(title, content)
                    noticeList.add(notice)
                    noticeAdapter.notifyDataSetChanged()
                }
            }
            .setNegativeButton("Cancel", null)
            .create()
            .show()



















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}