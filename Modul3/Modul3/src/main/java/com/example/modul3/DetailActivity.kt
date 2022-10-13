package com.example.modul3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvGetText: TextView = findViewById(R.id.tv_text1)
        val getText = intent?.getStringExtra(EXTRA_TEXT)  // tanda ( ? ) melihat apakah data ada didalam atau tidak
        tvGetText.text = getText
    }

    companion object{
     const val EXTRA_TEXT = "extra_text"
/*     const val EXTRA_BOOL = "extra_text"
     const val EXTRA_CAR = "extra_text"
     const val EXTRA_ANIME = "extra_text"
     const val EXTRA_ANIME = "extra_text"
     const val EXTRA_TEXT = "extra_text"*/
    }
}