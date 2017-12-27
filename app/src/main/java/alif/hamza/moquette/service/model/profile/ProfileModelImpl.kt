package alif.hamza.moquette.service.model.profile

import com.google.gson.GsonBuilder
import alif.hamza.moquette.App
import alif.hamza.moquette.model.Profile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileModelImpl : ProfileModel {

    override fun getProfile(listener: ProfileModel.OnGetProfile) {

        App.getService.getProfile().enqueue(object : Callback<Profile> {

            override fun onResponse(call: Call<Profile>?, response: Response<Profile>?) =
                    when {
                        response!!.isSuccessful -> listener.onSucess(response.body()!!)
                        response.code() == 401 -> listener.onFailGet()
                        else -> listener.onFailGet()
                    }


            override fun onFailure(call: Call<Profile>?, t: Throwable?) {
                listener.onFailGet()
            }
        })
    }

    override fun patchProfile(profile: Profile ,listener: ProfileModel.OnPatchProfile) {
        val gson = GsonBuilder().create()


        App.getService.patchProfile(gson.toJsonTree(profile)).enqueue(object : Callback<Void> {

            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                listener.onSucess()
            }

            override fun onFailure(call: Call<Void>?, t: Throwable?) {
                listener.onFailPatch()
            }

        })
    }
}