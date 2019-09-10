package com.example.newsreader

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if(intent != null){
            val uriString = intent.getStringExtra(ListActivity.URI_STRING)
            image.setImageURI(Uri.parse(uriString))
            val t = intent.getStringExtra(ListActivity.CONTENT_DESCRIPT)
            title_text.text = t
            val d = intent.getStringExtra(ListActivity.RANDOM_TEXT)
            description.text = d
        }
    }
}
