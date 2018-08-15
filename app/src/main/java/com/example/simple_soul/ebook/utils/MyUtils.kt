package com.example.simple_soul.ebook.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.support.v4.view.ViewCompat
import android.transition.TransitionInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.simple_soul.ebook.R

inline fun getRequestQueue(context: Context): RequestQueue
{
    var sRequestQueue: RequestQueue? = null

    if (sRequestQueue == null)
    {
        synchronized(RequestQueue::class.java) {
            if (sRequestQueue == null)
            {
                sRequestQueue = Volley.newRequestQueue(context)
            }
        }
    }
    return sRequestQueue!!
}

inline fun setStatusBarColor(activity: Activity, statusColor: Int)
{
    try
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            val window = activity.window
            //取消状态栏透明
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //添加Flag把状态栏设为可绘制模式
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //设置状态栏颜色
            window.statusBarColor = activity.resources.getColor(R.color.colorPrimary)
            //设置系统状态栏处于可见状态
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
            //让view不根据系统窗口来调整自己的布局
            val mContentView = window.findViewById(Window.ID_ANDROID_CONTENT) as ViewGroup
            val mChildView = mContentView.getChildAt(0)
            if (mChildView != null)
            {
                ViewCompat.setFitsSystemWindows(mChildView, false)
                ViewCompat.requestApplyInsets(mChildView)
            }
        }
    }
    catch (e: Exception)
    {
        e.printStackTrace()
    }
}

inline fun loadTransition(window: Window, context: Context)
{
    //添加activity跳转动画
    window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
    val fade = TransitionInflater.from(context).inflateTransition(R.transition.fade)
    val slide = TransitionInflater.from(context).inflateTransition(R.transition.slide)
    //退出时使用
    window.exitTransition = fade
    //第一次进入时使用
    window.enterTransition = slide
    //再次进入时使用
    window.reenterTransition = slide
}
