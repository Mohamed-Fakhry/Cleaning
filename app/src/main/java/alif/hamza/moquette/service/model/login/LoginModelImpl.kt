package alif.hamza.moquette.service.model.login

import com.google.gson.JsonObject
import alif.hamza.moquette.App
import alif.hamza.moquette.service.model.responed.ResponedLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModelImpl : LoginModel {

    override fun login(username: String, password: String, listener: LoginModel.OnLoginListener) {

        val user = JsonObject()
        user.addProperty("username", username)
        user.addProperty("password", password)

        App.getService.loginService(user).enqueue(object : Callback<ResponedLogin> {
            override fun onResponse(call: Call<ResponedLogin>, response: Response<ResponedLogin>) =
                    when {
                        response.isSuccessful -> listener.succeed(response.body()!!.token!!)
                        response.code() == 401 -> listener.failed()
                        else -> listener.failed()
                    }

            override fun onFailure(call: Call<ResponedLogin>, t: Throwable) {
                listener.failed()
            }
        })
    }
}
