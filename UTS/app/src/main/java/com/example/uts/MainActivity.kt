package com.example.uts

import PionerData
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.uts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var objectButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        objectButton = findViewById(R.id.objectButton)
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,
                R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.search_menu -> {
                Toast.makeText(this,"Pencarian belum tersedia", Toast.LENGTH_SHORT).show()
                return true
            }R.id.favorite_menu -> {
                Toast.makeText(this,"Favorite belum tersedia", Toast.LENGTH_SHORT).show()
                return true
            }R.id.setting_menu -> {
                Toast.makeText(this,"Pengaturan belum tersedia", Toast.LENGTH_SHORT).show()
                return true
            }R.id.logout_menu -> {
                Toast.makeText(this,"Anda tidak diizinkan keluar", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return false
        }
    }
    fun onClick(view: View){
        when(view.id){
            R.id.objectButton -> {
                val carSpek=PionerData(
                    "SATISFACTORY BASE",
                    "South Desert",
                    "Steel Factory",
                    "233.5 Items / Minute",
                    "930 Generation Power"
                )
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_PIONER, carSpek)
                intent.putExtra(DetailActivity.EXTRA_BOOL, true);
                startActivity(intent)
            }
        }

    }
}