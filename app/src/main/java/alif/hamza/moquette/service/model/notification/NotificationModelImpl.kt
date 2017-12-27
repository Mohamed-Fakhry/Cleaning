package alif.hamza.moquette.service.model.notification

import alif.hamza.moquette.App
import alif.hamza.moquette.model.Notifiction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationModelImpl : NotificationModel {

    override fun getNotifications(listener: NotificationModel.OnGetNotifications) {
        App.getService.getNotifications().enqueue(object : Callback<MutableList<Notifiction>> {

            override fun onResponse(call: Call<MutableList<Notifiction>>?, response: Response<MutableList<Notifiction>>?) =
                    if (response!!.isSuccessful) {
                        listener.onSucess(response.body()!!)
                    } else {
                        listener.onFail()
                    }

            override fun onFailure(call: Call<MutableList<Notifiction>>?, t: Throwable?) {

            }
        })
    }
}