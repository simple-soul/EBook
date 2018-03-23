import com.example.simple_soul.ebook.callback.Callback

abstract class BaseModel<T>
{
    //数据请求参数
    protected lateinit var mParams: Array<String>

    /**
     * 设置数据请求参数
     *
     * @param args 参数数组
     */
    fun params(args: Array<String>): BaseModel<*>
    {
        mParams = args
        return this
    }

    // 添加Callback并执行数据请求
    // 具体的数据请求由子类实现
    abstract fun execute(callback: Callback<T>)

    // 执行Get网络请求，此类看需求由自己选择写与不写
    protected fun requestGetAPI(url: String, callback: Callback<T>)
    {
        //这里写具体的网络请求
    }

    // 执行Post网络请求，此类看需求由自己选择写与不写
    protected fun requestPostAPI(url: String, params: Map<*, *>, callback: Callback<T>)
    {
        //这里写具体的网络请求
    }
}