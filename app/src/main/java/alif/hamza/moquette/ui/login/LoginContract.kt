package alif.hamza.moquette.ui.login

import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView

interface LoginContract {

    interface View : MvpView {

        fun onSuccess(token: String)
    }

    interface Presenter<V: View>: MvpPresenter<V> {

        fun validateLoginInfo(name: String?, password: String?)
    }
}
