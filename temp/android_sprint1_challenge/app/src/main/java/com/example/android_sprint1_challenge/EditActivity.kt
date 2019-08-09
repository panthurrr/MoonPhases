package com.example.android_sprint1_challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        save_button.setOnClickListener {
            val text = movie_text.getText().toString()
            if(text == ""){
                val intent = Intent()
            }
        }
    }
}
