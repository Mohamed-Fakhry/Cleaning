package alif.hamza.moquette.ui.notification

import com.example.computec.eltadreb.ui.base.BasePresenter
import alif.hamza.moquette.model.Notifiction
import alif.hamza.moquette.service.model.notification.NotificationModel
import alif.hamza.moquette.service.model.notification.NotificationModelImpl

class NotificationPresenter<V : NotifictionContract.View> : BasePresenter<V>(),
        NotifictionContract.Presenter<V>, NotificationModel.OnGetNotifications {

    var notificationModel: NotificationModel = NotificationModelImpl()

    override fun getNotifictions() {
        notificationModel.getNotifications(this)
    }

    override fun onSucess(notifictions: MutableList<Notifiction>) {
        mvpView!!.showNotifictions(notifictions)
    }

    override fun onFail() {}
}