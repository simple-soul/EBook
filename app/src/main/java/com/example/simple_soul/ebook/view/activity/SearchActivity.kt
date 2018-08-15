package com.example.simple_soul.ebook.view.activity

import com.example.simple_soul.ebook.R
import com.example.simple_soul.ebook.presenter.impl.SearchPresenterImpl
import com.example.simple_soul.ebook.utils.setStatusBarColor
import com.example.simple_soul.ebook.view.views.SearchView

class SearchActivity: BaseActivity(), SearchView
{
    private val searchPresenter = SearchPresenterImpl(this)

    override fun beforeSetContentView()
    {
        setStatusBarColor(this, R.color.colorPrimary)
    }

    override fun getLayout(): Int
    {
        return R.layout.activity_search
    }

    override fun init()
    {

    }

}
