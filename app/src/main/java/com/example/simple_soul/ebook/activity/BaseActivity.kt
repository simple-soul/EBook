
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast

abstract class BaseActivity : Activity(), BaseView {
    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mProgressDialog = ProgressDialog(this)
        mProgressDialog!!.setCancelable(false)
    }

    override fun showLoading() {
        if (!mProgressDialog!!.isShowing) {
            mProgressDialog!!.show()
        }
    }

    override fun hideLoading() {
        if (mProgressDialog!!.isShowing) {
            mProgressDialog!!.dismiss()
        }
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showErr() {
        showToast("error!!!")
    }

    override fun getContext(): Context {
        return this@BaseActivity
    }
}