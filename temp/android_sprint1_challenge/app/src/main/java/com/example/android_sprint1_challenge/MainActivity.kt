package com.example.android_sprint1_challenge

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movie_button.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            this.startActivity(intent)
        }
    }

    fun createTextView(content : String, has_been_watched : Boolean) : TextView{
        val text_view = TextView(this)
        text_view.text = content
        text_view.textSize = 24f
        text_view.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        if(has_been_watched){
            text_view.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)
        }

        return text_view
    }
}
