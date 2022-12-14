package com.example.modul6

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modul6.databinding.ActivityMainBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Anime>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getListAnime()

//        list.addAll(listAnime)
//        showRecyclerList()
    }

    private fun getListAnime(){
        val client = AsyncHttpClient()
        val url = "https://anime-facts-rest-api.herokuapp.com/api/v1"
        client.get(url,object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out cz.msebera.android.httpclient.Header>?,
                responseBody: ByteArray
            ) {
                val result = String(responseBody)
                try{
                    val responseObject = JSONObject(result)
                    val data = responseObject.getString("data")
                    val jsonArray = JSONArray(data)
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        val id = jsonObject.getInt("anime_id")
                        val name = jsonObject.getString("anime_name")
                        val img = jsonObject.getString("anime_img")

                        list.add(Anime(id,name,img))
                    }
                    showRecycler()
                }catch (e: Exception){
                    Toast.makeText(this@MainActivity,
                        e.message, Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(
                statusCode: Int,
                headers: Array<out cz.msebera.android.httpclient.Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            )
            {
                Toast.makeText(this@MainActivity,statusCode,Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showRecycler(){
        if(applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.listAnime.layoutManager = GridLayoutManager(this,2)
        }else{
            binding.listAnime.layoutManager = LinearLayoutManager(this)
        }

        val adapter = AnimeAdapter(list)
        binding.listAnime.adapter = adapter

        adapter.setOnItemClickCallback(object : AnimeAdapter.OnItemClickCallback{
            override fun onItemClicked(data:Anime){
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_ANIME, data.name)
                intent.putExtra(DetailActivity.EXTRA_ANIME_IMG, data.img)
                startActivity(intent)
//                Toast.makeText(this@MainActivity,"INI ANIME ${data.name}",Toast.LENGTH_SHORT).show()
            }
        })
    }
}
