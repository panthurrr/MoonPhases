package com.example.moonphases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var calendarListAdapter: CalendarListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        //get the current month and create a list with the amount of days in it
        val calendar = Calendar.getInstance()
        val monthName = SimpleDateFormat("MMMM").format(calendar.time)
        tv_month_name.text = monthName
        val dayData = mutableListOf<DayData>()
//        Toast.makeText(applicationContext, "${(calendar.getActualMaximum(Calendar.DAY_OF_MONTH))}", Toast.LENGTH_SHORT).show()

        (0..calendar.getActualMaximum(Calendar.DAY_OF_MONTH)).forEach { day->
            dayData.add(DayData(day, (0..7).random()))
        }
        calendarListAdapter = CalendarListAdapter(dayData)

        rv_calendar.apply {
            adapter = calendarListAdapter
            layoutManager = GridLayoutManager(context, 5)
        }
    }
}