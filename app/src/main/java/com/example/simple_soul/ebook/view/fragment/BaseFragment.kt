package com.example.simple_soul.ebook.view.fragment

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simple_soul.ebook.view.activity.BaseActivity
import com.example.simple_soul.ebook.view.views.BaseView


abstract class BaseFragment: Fragment(), BaseView
{
    abstract fun getContentViewId(): Int
    protected abstract fun initAllMembersView(savedInstanceState: Bundle?)
    protected lateinit var mContext: Context
    protected lateinit var mRootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        mRootView = inflater.inflate(getContentViewId(), container, false)
        this.mContext = activity
        initAllMembersView(savedInstanceState)
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    abstract fun initData()

    override fun showLoading()
    {
        checkActivityAttached()
        (mContext as BaseActivity).showLoading()
    }

    fun showLoading(msg: String)
    {
        checkActivityAttached()
        (mContext as BaseActivity).showLoading()
        showToast(msg)
    }

    override fun hideLoading()
    {
        checkActivityAttached()
        (mContext as BaseActivity).hideLoading()
    }

    override fun showToast(msg: String)
    {
        checkActivityAttached()
        (mContext as BaseActivity).showToast(msg)
    }

    override fun showErr()
    {
        checkActivityAttached()
        (mContext as BaseActivity).showErr()
    }

    protected fun isAttachedContext(): Boolean
    {
        return activity != null
    }

    /**
     * 检查activity连接情况
     */
    private fun checkActivityAttached()
    {
        if (activity == null)
        {
            throw ActivityNotAttachedException()
        }
    }

    class ActivityNotAttachedException : RuntimeException("Fragment has disconnected from Activity ! - -.")

}