package com.example.socityapppankaj

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EventOrganisation : AppCompatActivity() {
    private val eventList = mutableListOf<Event>()
    private lateinit var eventAdapter: EventAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_event_organisation)






                val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
                recyclerView.layoutManager = LinearLayoutManager(this)

                eventAdapter = EventAdapter(eventList)
                recyclerView.adapter = eventAdapter

                val eventTitle: EditText = findViewById(R.id.event_title_input)
                val eventDate: EditText = findViewById(R.id.event_date_input)
                val eventDescription: EditText = findViewById(R.id.event_description_input)
                val addButton: Button = findViewById(R.id.add_event_button)

                addButton.setOnClickListener {
                    val title = eventTitle.text.toString()
                    val date = eventDate.text.toString()
                    val description = eventDescription.text.toString()

                    eventList.add(Event(title, date, description))
                    eventAdapter.notifyDataSetChanged()

                    eventTitle.text.clear()
                    eventDate.text.clear()
                    eventDescription.text.clear()
                }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}