class BasePresenter<V : BaseView> {
    /**
     * 绑定的view
     */
    /**
     * 获取连接的view
     */
    var view: V? = null
        private set

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    val isViewAttached: Boolean
        get() = view != null

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    fun attachView(mvpView: V) {
        this.view = mvpView
    }

    /**
     * 断开view，一般在onDestroy中调用
     */
    fun detachView() {
        this.view = null
    }
}