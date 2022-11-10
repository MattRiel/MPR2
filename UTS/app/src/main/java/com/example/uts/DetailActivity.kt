package com.example.uts

import PionerData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TEXT="extra_text"
        const val EXTRA_BOOL="extra_bool"
        const val EXTRA_PIONER="extra_car"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val textView: TextView = findViewById(R.id.textView)
        val tvGetText:TextView = findViewById(R.id.tvGetText)

        val getText = intent?.getStringExtra(EXTRA_TEXT)
        textView.text = getText

        val getBool=intent?.getBooleanExtra(EXTRA_BOOL, false)
        if(getBool==true){
            val getPion = intent?.getParcelableExtra<PionerData>(EXTRA_PIONER)
            Log.i("TAG", getPion?.name.toString())
            val pionData="FACTORY specification:\n"+
                    "\nName: ${getPion?.name.toString()}"+
                    "\nLocation: ${getPion?.location.toString()}"+
                    "\nType: ${getPion?.type.toString()}"+
                    "\nRate: ${getPion?.rate.toString()}"+
                    "\nPower Consumption: ${getPion?.power_consume.toString()}"
            tvGetText.text=pionData;
        }
    }
}
