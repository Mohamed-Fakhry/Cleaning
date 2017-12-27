package alif.hamza.moquette.ui.notification

import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView
import alif.hamza.moquette.model.Notifiction

interface NotifictionContract {

    interface View : MvpView {
        fun showNotifictions(notifications: MutableList<Notifiction>)
    }

    interface Presenter<V: View>: MvpPresenter<V> {
        fun getNotifictions()
    }
}