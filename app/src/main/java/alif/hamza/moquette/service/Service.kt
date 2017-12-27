package alif.hamza.moquette.service

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import alif.hamza.moquette.model.Notifiction
import alif.hamza.moquette.model.OrderCart
import alif.hamza.moquette.model.Price
import alif.hamza.moquette.model.Profile
import alif.hamza.moquette.service.model.responed.ResponedLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface Service {

    @POST("login")
    fun loginService(@Body user: JsonObject): Call<ResponedLogin>

    @POST("signup")
    fun signupService(@Body user: JsonObject): Call<Void>

    @GET("profile")
    fun getProfile(): Call<Profile>

    @PATCH("profile")
    fun patchProfile(@Body profile: JsonElement): Call<Void>

    @GET("prices")
    fun getPrices(): Call<MutableList<Price>>

    @GET("orders")
    fun getOrders(): Call<MutableList<OrderCart>>

    @POST("orders")
    fun postOrder(@Body order: JsonElement): Call<Void>

    @POST("register-device")
    fun sendToken(@Body token: JsonObject): Call<Void>

    @GET("notifications")
    fun getNotifications(): Call<MutableList<Notifiction>>
}