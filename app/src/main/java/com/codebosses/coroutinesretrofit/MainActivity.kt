package com.codebosses.coroutinesretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitFactory.makeRetrofitService()

        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getUpcomingMovies("0021549a1c767c99bc531d078d1cda1a","en-US",1)
            withContext(Dispatchers.Main){
                try{
                    if(response.isSuccessful){
                        Toast.makeText(this@MainActivity,response.body().toString(),Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@MainActivity,"Error: ${response.code()}",Toast.LENGTH_LONG).show()
                    }
                }catch (e: Exception){
                    Toast.makeText(this@MainActivity,e.message.toString(),Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}
