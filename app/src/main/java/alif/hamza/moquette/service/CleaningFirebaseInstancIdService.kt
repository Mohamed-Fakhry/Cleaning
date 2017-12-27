package alif.hamza.moquette.service

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import com.google.gson.JsonObject
import alif.hamza.moquette.App
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CleaningFirebaseInstancIdService: FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        val refreshedToken = FirebaseInstanceId.getInstance().token

        val token = JsonObject()
        token.addProperty("deviceType", "android")
        token.addProperty("deviceToken", refreshedToken)
        App.getService.sendToken(token).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {}

            override fun onFailure(call: Call<Void>, t: Throwable) {}
        })
    }
}