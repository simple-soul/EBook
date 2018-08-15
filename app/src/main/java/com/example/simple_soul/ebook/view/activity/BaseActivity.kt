package com.example.simple_soul.ebook.view.activity

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.simple_soul.ebook.view.views.BaseView

abstract class BaseActivity : AppCompatActivity(), BaseView
{
    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mProgressDialog = ProgressDialog(this)
        mProgressDialog!!.setCancelable(false)

        beforeSetContentView()
        setContentView(getLayout())
        init()
    }

    protected open fun beforeSetContentView() {}

    abstract fun getLayout(): Int

    abstract fun init()

    override fun showLoading()
    {
        if (!mProgressDialog!!.isShowing)
        {
            mProgressDialog!!.show()
        }
    }

    override fun hideLoading()
    {
        if (mProgressDialog!!.isShowing)
        {
            mProgressDialog!!.dismiss()
        }
    }

    override fun showToast(msg: String)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showErr()
    {
        showToast("error!!!")
    }

    override fun getContext(): Context
    {
        return this@BaseActivity
    }
}