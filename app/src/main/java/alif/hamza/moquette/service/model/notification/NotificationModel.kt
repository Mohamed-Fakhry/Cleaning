package alif.hamza.moquette.service.model.notification

import alif.hamza.moquette.model.Notifiction

interface NotificationModel {

    interface OnGetNotifications {
        fun onSucess(notifictions: MutableList<Notifiction>)
        fun onFail()
    }

    fun getNotifications(listener: OnGetNotifications)
}