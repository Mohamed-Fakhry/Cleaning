package com.example.computec.eltadreb.ui.base

import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.View
import com.example.computec.eltadreb.utils.CommonUtils

abstract class BaseFragment : Fragment(), MvpView {

    var baseActivity: BaseActivity? = null

    private var mProgressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(null)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.baseActivity = activity
            activity!!.onFragmentAttached()
        }
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(this.context)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    override fun onError(message: String?) {
        baseActivity!!.onError(message)
    }

    override fun onError(@StringRes resId: Int) {
        baseActivity!!.onError(resId)
    }

    override fun showMessage(message: String?) {
        baseActivity!!.showMessage(message)
    }

    override fun showMessage(@StringRes resId: Int) {
        baseActivity!!.showMessage(resId)
    }

    override fun isNetworkConnected(): Boolean = baseActivity!!.isNetworkConnected()

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    override fun hideKeyboard() {
        baseActivity!!.hideKeyboard()
    }

    override fun openActivityOnTokenExpire() {
        baseActivity!!.openActivityOnTokenExpire()
    }

    protected abstract fun setUp(view: View?)

    override fun onDestroy() {
        super.onDestroy()
    }

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}
