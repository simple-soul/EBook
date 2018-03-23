import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment(), BaseView
{
    abstract fun contentViewId(): Int

    protected lateinit var mContext: Context
    protected lateinit var mRootView: View

    protected val isAttachedContext: Boolean
        get() = activity != null

    protected abstract fun initAllMembersView(savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        mRootView = inflater!!.inflate(contentViewId(), container, false)
        this.mContext = activity
        initAllMembersView(savedInstanceState)
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    protected abstract fun initData()

    override fun showLoading()
    {
        checkActivityAttached()
        (mContext as BaseActivity).showLoading()
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

    /**
     * 检查activity连接情况
     */
    fun checkActivityAttached()
    {
        if (activity == null)
        {
            throw ActivityNotAttachedException()
        }
    }

    class ActivityNotAttachedException : RuntimeException("Fragment has disconnected from Activity ! - -.")
}