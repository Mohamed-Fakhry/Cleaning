package alif.hamza.moquette.ui.login

import com.example.computec.eltadreb.ui.base.BasePresenter
import alif.hamza.moquette.R

import alif.hamza.moquette.service.model.login.LoginModel
import alif.hamza.moquette.service.model.login.LoginModelImpl

class LoginPresenter<V: LoginContract.View> : BasePresenter<V>()
        , LoginContract.Presenter<V>, LoginModel.OnLoginListener {

    private val loginModel: LoginModel

    init {
        this.loginModel = LoginModelImpl()
    }

    override fun validateLoginInfo(username: String?, password: String?) {
        if((username == null || username.isEmpty()) && (password == null || password.isEmpty())) {
            mvpView?.onError(R.string.empty_username_and_password)
            return
        } else if (username == null || username.isEmpty()) {
            mvpView?.onError(R.string.empty_username)
            return
        } else if (password == null || password.isEmpty()) {
            mvpView?.onError(R.string.empty_password)
            return
        }

        if (mvpView!!.isNetworkConnected()) {
            mvpView?.showLoading()
            loginModel.login(username, password, this)
        } else {
            mvpView?.onError(R.string.error_no_internet_connection)
        }
    }

    override fun succeed(token: String) {
        mvpView?.hideLoading()
        mvpView?.onSuccess(token)
    }

    override fun failed() {
        mvpView?.hideLoading()
        mvpView?.onError("")
    }
}
