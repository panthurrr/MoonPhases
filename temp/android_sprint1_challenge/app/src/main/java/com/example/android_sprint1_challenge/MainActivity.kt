package com.example.android_sprint1_challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}
