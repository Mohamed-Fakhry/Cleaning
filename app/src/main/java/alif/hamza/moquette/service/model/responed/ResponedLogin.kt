package alif.hamza.moquette.service.model.responed

import com.google.gson.annotations.SerializedName

class ResponedLogin {
    @SerializedName("accessToken")
    internal var token: String? = null
}