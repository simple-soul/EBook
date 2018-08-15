package com.example.simple_soul.ebook.presenter

import com.example.simple_soul.ebook.view.views.BaseView

interface IBasePresenter<V: BaseView>
{
    /**
     * 绑定的view
     */
    var mvpView: V?

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    fun attachView(mvpView: V) {
        this.mvpView = mvpView
    }

    /**
     * 断开view，一般在onDestroy中调用
     */
    fun detachView() {
        this.mvpView = null
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    fun isViewAttached(): Boolean {
        return mvpView != null
    }

    /**
     * 获取连接的view
     */
    fun getView(): V? {
        return mvpView
    }
}