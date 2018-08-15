package com.example.simple_soul.ebook.model.models

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.simple_soul.ebook.MyApplication
import com.example.simple_soul.ebook.utils.Callback

open class BaseModel<T> {
    //数据请求参数
    protected lateinit var mParams: Array<String>

    /**
     * 设置数据请求参数
     * @param args 参数数组
     */
    fun params(vararg args: String): BaseModel<*>
    {
        mParams = args as Array<String>
        return this
    }

    // 添加Callback并执行数据请求
    // 具体的数据请求由子类实现
    open fun execute(callback: Callback<T>) {}

    // 执行Get网络请求，此类看需求由自己选择写与不写
    open fun requestGet(url: String, callback: Callback<String>) {
        val stringRequest = StringRequest(url,
                Response.Listener<String> { response -> callback.onSuccess(response) },
                Response.ErrorListener { error -> callback.onFailure(error) })
        callback.onComplete()
        MyApplication.mQueue.add(stringRequest)
    }

    // 执行Post网络请求，此类看需求由自己选择写与不写
    open fun requestPost(url: String, params: MutableMap<String, String>, callback: Callback<String>) {
        val stringRequest = object : StringRequest(Request.Method.POST, url,
                Response.Listener<String> { response -> callback.onSuccess(response) },
                Response.ErrorListener { error -> callback.onFailure(error) })
        {
                override fun getParams(): MutableMap<String, String>
                {
                    return params
                }
        }
        callback.onComplete()
        MyApplication.mQueue.add(stringRequest)
    }

//    open fun requestJSONPost(url: String, params: Map<String, String>, callback: Callback<T>) {
//        val jsonRequest =
//    }
//
//    open fun requestJSONPost(url: String, params: Map<String, String>, callback: Callback<T>) {
//        val jsonRequest =
//    }
}
