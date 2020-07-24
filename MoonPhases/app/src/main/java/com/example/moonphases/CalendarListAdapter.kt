package com.example.moonphases

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalendarListAdapter(private val dayData: List<DayData>): RecyclerView.Adapter<CalendarListAdapter.CalendarViewHolder>() {

    private lateinit var context: Context

    class CalendarViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvDay = view.findViewById<TextView>(R.id.tv_day_month)
        val imgMoonPhase = view.findViewById<ImageView>(R.id.img_moon_phase)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        context = parent.context
        return CalendarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.moon_phase_view, parent,false))
    }

    override fun getItemCount() = dayData.size

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.tvDay.text = "$position"
        holder.imgMoonPhase.setImageDrawable(context.getDrawable(dayData[position].moonPhase.drawableRes))
    }
}