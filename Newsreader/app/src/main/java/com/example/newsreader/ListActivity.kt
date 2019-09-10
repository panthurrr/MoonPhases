package com.example.newsreader

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private val imageList = mutableListOf<ImageView>()

    companion object{
        const val URI_STRING = "URI_STRING"
        const val CONTENT_DESCRIPT = "CONTENT_DESCRIPT"
        const val RANDOM_TEXT = "RANDOM"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val imageUri = "android.resource://com.example.newsreader/drawable/"

        imageList[0] = generateImageView(Uri.parse(imageUri + R.drawable.abstract_abstract_expressionism_art_2505693),
            getString(R.string.abstract_art))

        imageList[1] = generateImageView(Uri.parse(imageUri + R.drawable.adventure_automobile_classic_2533092),
            getString(R.string.classic_automobile))

        imageList[2] = generateImageView(Uri.parse(imageUri + R.drawable.aerial_photography_aerial_shot_aerial_view_2583847),
            getString(R.string.aerial_photography))

        imageList[3] = generateImageView(Uri.parse(imageUri + R.drawable.afterglow_beach_cliff_2555285),
            getString(R.string.beach_cliff))

        imageList[4] = generateImageView(Uri.parse(imageUri + R.drawable.alley_architecture_buildings_2526517),
            getString(R.string.abstract_art))

        imageList[5] = generateImageView(Uri.parse(imageUri + R.drawable.architectural_design_architecture_bridge_2540653),
            getString(R.string.abstract_art))

        imageList[6] = generateImageView(Uri.parse(imageUri + R.drawable.beautiful_breathtaking_canada_day_2526105),
            getString(R.string.canada_day))

        imageList[7] = generateImageView(Uri.parse(imageUri + R.drawable.bloom_blossom_flora_2567011),
            getString(R.string.flora_bossom))

        imageList.forEachIndexed {
            index, element ->
            if(index.rem(2) == 0){
                left_column.addView(element)
            } else {
                right_column.addView(element)
            }
        }
    }

    private fun generateImageView(uri : Uri, contentDescription : String) : ImageView{
        val img = ImageView(this)
        img.setImageURI(uri)
        img.contentDescription = contentDescription

        img.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(URI_STRING, uri)
            intent.putExtra(CONTENT_DESCRIPT, contentDescription)
            intent.putExtra(RANDOM_TEXT, R.string.lorem_ipsum)
            startActivity(intent)
        }
        return img
    }
}
