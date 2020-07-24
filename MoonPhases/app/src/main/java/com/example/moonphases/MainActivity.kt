package com.example.moonphases

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var calendarListAdapter: CalendarListAdapter
    private lateinit var broadcastReceiver: BroadcastReceiver
    private val dayData = mutableListOf<DayData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver()
        initRecyclerView()
    }

    override fun onResume() {
        if(!MoonPhaseService.serviceIsOn){
            val i = Intent("com.example.moonphases.MoonPhaseService")
            i.setClass(applicationContext, MoonPhaseService::class.java)
            applicationContext.startService(i)
            registerReceiver()
        }
        super.onResume()
    }

    override fun onStop() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        super.onStop()
    }

    private fun initRecyclerView(){
        //get the current month and create a list with the amount of days in it
        val calendar = Calendar.getInstance()
        val monthName = SimpleDateFormat("MMMM").format(calendar.time)
        tv_month_name.text = monthName

        (0..calendar.getActualMaximum(Calendar.DAY_OF_MONTH)).forEach { day->
            if(day == Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) {
                MoonPhaseService.currentMoonPhase?.let { phase->
                    dayData.add(DayData(day, phase))
                }
            } else
                dayData.add(DayData(day, MoonPhase.findByValue((0..7).random())!!))
        }
        calendarListAdapter = CalendarListAdapter(dayData)

        rv_calendar.apply {
            adapter = calendarListAdapter
            layoutManager = GridLayoutManager(context, 5)
        }
    }

    private fun registerReceiver() {
        broadcastReceiver = object: BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                intent?.let{
                    //update UI to reflect the change in today's current moon phase
                    val currentDayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                    dayData[currentDayOfMonth].moonPhase = it.getSerializableExtra("CurrentMoonPhase") as MoonPhase
                    calendarListAdapter.notifyItemChanged(currentDayOfMonth)
                }
            }
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(
            broadcastReceiver, IntentFilter("notificationAction"))
    }
}