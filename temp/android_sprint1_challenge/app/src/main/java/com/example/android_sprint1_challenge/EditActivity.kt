package com.example.android_sprint1_challenge

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    companion object{
        const val MOVIE_ENTRY = "1"
        const val WATCHED_OR_NOT = "2"
        const val DELETE_MOVIE = "3"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        save_button.setOnClickListener {
            onBackPressed()
        }

        delete_button.setOnClickListener {view ->
            val movie = movie_text.text
            val intent = Intent()
            intent.putExtra(DELETE_MOVIE, movie)

            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }

    override fun onBackPressed() {
        val movie = movie_text.text
        val watched = watched_or_not.isChecked()

        val intent = Intent()

        intent.putExtra(MOVIE_ENTRY, movie)
        intent.putExtra(WATCHED_OR_NOT, watched)

        setResult(Activity.RESULT_OK, intent)

        finish()
    }
}
