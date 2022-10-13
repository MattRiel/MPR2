package com.example.modul3

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // deklarasi variabel
    private lateinit var teksJudul : TextView
    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var teks    : EditText


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // menghubungkan variabel dengan id pada komponen
//        teksJudul = findViewById(R.id.textView)
        button1   = findViewById(R.id.btn_intent_explicit)
        button2   = findViewById(R.id.button2)
        button3   = findViewById(R.id.button3)
        teks      = findViewById(R.id.etKirimData)

        var tulisan = teks.text

    /*    button1.setOnClickListener(){
            teksJudul.text = tulisan.toString()
        }*/

    }

    fun onClick(view: View){
        when(view.id){

            // INTENT EXPLICIT
            R.id.btn_intent_explicit -> {
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                startActivity(intent)
            }

            // INTENT DAN MENGIRIM DATA
            R.id.button2 -> {
                val text = teks.text.toString()
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_TEXT, text)
                startActivity(intent)
            }


            // INTENT IMPLICIT
            R.id.button4 -> {
                val phoneNumber = "081375432593"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }





        }
    }


}

//  Dasar Teori
// Intent Explicit : tujuannya jelas dan menggunakan nama kelas yang dituju misal menuju ke MainActivity
// atau mengirim data dari MainActivity

/*Intent Implicit : tujuannya tidak jelas dan tidak memerlukan nama kelas
* */