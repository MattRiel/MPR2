package com.example.pert2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // menghubungkan variabel dengan id pada komponen
        teksJudul = findViewById(R.id.textView)
        button1   = findViewById(R.id.button1)
        button3   = findViewById(R.id.button2)
        button2   = findViewById(R.id.button3)
        teks      = findViewById(R.id.editTextTextPersonName)

        var tulisan = teks.text

        button1.setOnClickListener(){
            teksJudul.text = tulisan.toString()
        }

    }


}

//  Dasar Teori
// view adalah objek visual yang ditampilkan pada layar device dan dapat berinteraksi dengan user
// view group adalah tempat untuk menampung view dan juga view group itu sendiri

/*
Layout adalah susunan komponen yang terdiri dari beberapa baris atau kolom dalam mengatur
peletakan dari komponen. Contoh adalah layout horizontal dan layout vertikal.


Margin adalah jarak komponen ke luar
Padding adalah jarak komponen ke dalam
 */