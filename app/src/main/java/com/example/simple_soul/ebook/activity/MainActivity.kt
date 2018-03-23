package com.example.simple_soul.ebook.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.simple_soul.ebook.R
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getHtml()
    }

    fun getHtml()
    {
        Thread(Runnable {
            val doc = Jsoup.connect("http://www.biquge5200.com/").get()

            Log.i("main", doc.toString())
        }).start()
    }

}
