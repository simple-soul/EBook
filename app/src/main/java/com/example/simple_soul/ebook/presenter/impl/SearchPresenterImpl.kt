package com.example.simple_soul.ebook.presenter.impl

import com.example.simple_soul.ebook.presenter.IBasePresenter
import com.example.simple_soul.ebook.presenter.SearchPresenter
import com.example.simple_soul.ebook.view.views.SearchView

open class SearchPresenterImpl(override var mvpView: SearchView?) : SearchPresenter, IBasePresenter<SearchView>
{

}