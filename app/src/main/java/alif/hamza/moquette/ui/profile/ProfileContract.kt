package alif.hamza.moquette.ui.profile

import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView
import alif.hamza.moquette.model.Profile

interface ProfileContract {

    interface View : MvpView {
        fun showProfile(profile: Profile)
    }

    interface Presenter<V: View> : MvpPresenter<V> {
        fun getProfile()
        fun editProfile(profile: Profile)
    }
}