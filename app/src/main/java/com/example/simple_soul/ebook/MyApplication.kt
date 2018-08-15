package com.example.simple_soul.ebook

import android.app.Application
import com.android.volley.RequestQueue
import com.example.simple_soul.ebook.utils.getRequestQueue

class MyApplication: Application()
{
    companion object
    {
        lateinit var mQueue: RequestQueue
    }

    override fun onCreate()
    {
        super.onCreate()
        init()
    }

    private fun init()
    {
        mQueue = getRequestQueue(this)
    }


}