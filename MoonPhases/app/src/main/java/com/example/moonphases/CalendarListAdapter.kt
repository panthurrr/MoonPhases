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
        holder.imgMoonPhase.setImageDrawable(
            when(dayData[position].moonPhase) {
                0 -> context.getDrawable(R.drawable.ic_first_quarter)
                1 -> context.getDrawable(R.drawable.ic_full_moon)
                2 -> context.getDrawable(R.drawable.ic_new_moon)
                3 -> context.getDrawable(R.drawable.ic_third_quarter)
                4 -> context.getDrawable(R.drawable.ic_waning_crescent)
                5 -> context.getDrawable(R.drawable.ic_waning_gibbous)
                6 -> context.getDrawable(R.drawable.ic_waxing_crescent)
                7 -> context.getDrawable(R.drawable.ic_waxing_gibbous)
                else -> null
            }
        )
    }
}